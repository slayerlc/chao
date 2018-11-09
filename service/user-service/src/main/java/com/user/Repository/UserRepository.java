package com.user.Repository;

import com.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @Author: lvchao
 * @Date: 2018-11-07 10:09
 * @Email:641819417@qq.com
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long>,JpaSpecificationExecutor<User>{

    User findUserByAccount(String account);

    User findUserByAccountAndPassword(String account,String password);
}
