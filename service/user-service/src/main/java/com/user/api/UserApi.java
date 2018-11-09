package com.user.api;

import com.general.ResultMap;
import com.user.entity.User;
import com.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;

/**
 * @author lvchao
 * @date 2018/6/13
 */
@RestController
@RequestMapping(value = "user")
public class UserApi {

    @Autowired
    UserService userService;

    /**
     * 添加用户
     * @param user
     * @return
     */
    @PostMapping(value = "addUser")
    public ResultMap addUser(@RequestBody User user){
        return new ResultMap(userService.addUser(user));
    }

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    @PostMapping
    public ResultMap updateUser(@RequestBody User user){
        return new ResultMap();
    }

    /**
     * 返回所有用户
     * @return
     */
    @GetMapping(value = "findAll")
    public ResultMap findAll(){
        return new ResultMap(userService.findAll());
    }

    /**
     * 分页查找用户
     * @param user
     * @param pageable
     * @return
     */
    @RequestMapping(value = "findUserByPage")
    public ResultMap findUserByPage(@RequestBody User user, Pageable pageable){
        return new ResultMap();
    }

}
