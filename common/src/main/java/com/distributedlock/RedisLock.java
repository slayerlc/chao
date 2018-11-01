package com.distributedlock;

import com.model.Lock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisCommands;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisClusterCommand;
import redis.clients.jedis.JedisCommands;

import java.lang.reflect.Field;
import java.util.UUID;

/**
 * @Author: lvchao
 * @Date: 2018-10-11 9:24
 * @Email:641819417@qq.com
 */
@Slf4j
@Component
public class RedisLock {

    private static final RedisLock redisLock = new RedisLock();

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private static final long TIMEOUT = 1000L;

    private static final int TRYNUMBER = 10;

    private static final long LOCKEXPIRETIME = 100000L;

    private static final String SETNX = "NX";

    private static final String SETPX = "PX";

    ThreadLocal<String> threadLocal = new ThreadLocal<String>();

    /**
     * 这里应该针对每一条数据 用不同的key。而不是所有的请求都用同一个锁
     *
     * @param lock           key数据ID作为锁的key    value拿到锁的当前线程的标识    当前线程只能释放 自己加的锁
     * @param timeout        间隔多少秒尝试一次
     * @param tryNumber      尝试获得锁的次数
     * @param lockExpireTime 上锁时间多少毫秒过期
     * @return
     */
    private boolean addLock(Lock lock, long timeout, int tryNumber, long lockExpireTime) {
        if (lock == null || StringUtils.isEmpty(lock.getKey())) {
            return false;
        }
        //如果前面一个请求没有释放锁 则循环尝试获得锁 直到前面一个请求释放锁  或者超过尝试次数
        do {
            //超过尝试获取锁的次数 则退出
            if (--tryNumber <= 0) {
                return false;
            }
            synchronized (redisTemplate){
                if (!redisTemplate.hasKey(lock.getKey())) {
                    // value 保存到 当前线程的变量里   在解锁的时候 判断一下该锁 是不是此线程上的锁 如果不是则不能解锁其他线程上的锁
                    threadLocal.set(lock.getValue());
                    //添加锁
                    String result = redisTemplate.execute(new RedisCallback<String>() {
                        @Override
                        public String doInRedis(RedisConnection redisConnection) throws DataAccessException {
                            Object connection = redisConnection.getNativeConnection();
                            JedisCommands jedis = (JedisCommands) redisConnection.getNativeConnection();
                            return jedis.set(lock.getKey(), lock.getValue(), SETNX, SETPX, LOCKEXPIRETIME);
                        }
                    });
                    if (result.equals("OK")) {
                        return true;
                    } else {
                        throw new RuntimeException("数据加锁失败,请从新尝试!");
                    }
                }
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

    /**
     * 这里其实也保证不了原子性  网上看的方案是使用lua 脚本去执行
     * @param key
     * @return
     */
    public boolean unLock(String key) {
        if (redisTemplate.hasKey(key)) {
            Object value = redisTemplate.opsForValue().get(key);
            //这里存在一种情况 当线程A准备解锁的时候 此数据的锁正好过期 这个时候突然线程B又拿到了这个key给数据上锁  A这个时候正好执行delete(key)这行代码 结果A把B上的锁给删除了
            //通过threadLocal 和 value 对比 当前解锁的线程和上锁的线程必须是同一个
            if (value != null && value.equals(threadLocal.get())) {
                return redisTemplate.delete(key);
            }
        }
        return false;
    }

    public boolean addLock(String key) {
        Lock lock = new Lock();
        lock.setKey(key);
        lock.setValue(UUID.randomUUID().toString());
        return addLock(lock, TIMEOUT, TRYNUMBER, LOCKEXPIRETIME);
    }
}
