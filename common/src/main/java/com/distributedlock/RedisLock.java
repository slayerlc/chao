package com.distributedlock;

import com.model.Lock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;
import redis.clients.jedis.JedisCommands;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @Author: lvchao
 * @Date: 2018-10-11 9:24
 * @Email:641819417@qq.com
 */
@Slf4j
public class RedisLock {

    //@Autowired
    RedisTemplate redisTemplate = new RedisTemplate();

    private static final long TIMEOUT = 1000L;

    private static final int TRYNUMBER = 10;

    private static final long LOCKEXPIRETIME = 10L;

    ThreadLocal<String> threadLocal = new ThreadLocal<String>();

    /**
     * 这里应该针对每一条数据 用不同的key。而不是所有的请求都用同一个锁
     *
     * @param lock           key数据ID作为锁的key    value拿到锁的当前线程的标识    当前线程只能释放 自己加的锁
     * @param timeout
     * @param tryNumber
     * @param lockExpireTime
     * @return
     */
    private boolean addLock(Lock lock, long timeout, int tryNumber, long lockExpireTime) {
        if (lock == null || StringUtils.isEmpty(lock.getKey()) || StringUtils.isEmpty(lock.getValue())) {
            return false;
        }
        //如果前面一个请求没有释放锁 则循环尝试获得锁 直到前面一个请求释放锁  或者超过尝试次数
        do {
            //超过尝试获取锁的次数 则退出
            if (--tryNumber <= 0) {
                return false;
            }
            if (redisTemplate.hasKey(lock.getKey())) {
                log.debug("该条数据已经以锁定!");
            } else {
                //给数据上锁
                // value 保存到 当前线程的变量里   在解锁的时候 判断一下该锁 是不是此线程上的锁 如果不是则不能解锁其他线程上的锁
                threadLocal.set(UUID.randomUUID().toString());
                lock.setValue(threadLocal.get());
                Object result = redisTemplate.execute(new RedisCallback<String>() {
                    @Nullable
                    @Override
                    public String doInRedis(RedisConnection redisConnection) throws DataAccessException {
                        JedisCommands jedisCommands = (JedisCommands) redisConnection.getNativeConnection();
                        return jedisCommands.set(lock.getKey(), lock.getValue(), "NX", "PX", LOCKEXPIRETIME);
                    }
                });
                return true;
            }
            try {
                //间隔多少秒尝试一次
                Thread.sleep(timeout);
            } catch (InterruptedException e) {
                e.printStackTrace();
                return false;
            }
        } while (redisTemplate.hasKey(lock.getKey()));
        return false;
    }

    public boolean unLock(String key) {
        if (redisTemplate.hasKey(key)) {
            Object value = redisTemplate.opsForValue().get(key);
            if (value != null && value.equals(threadLocal.get())) {
                return redisTemplate.delete(key);
            }
        }
        return false;
    }

    public boolean getLock(Lock lock) {
        return addLock(lock, TIMEOUT, TRYNUMBER, LOCKEXPIRETIME);
    }

    public static void main(String args[]) {

    }
}
