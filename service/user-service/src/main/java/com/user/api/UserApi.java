package com.user.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonView;
import com.general.ResultMap;
import com.user.entity.User;
import com.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


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
     * 登录
     */
    @PostMapping(value = "login")
    public ResultMap login(@RequestBody User user){
        return new ResultMap(userService.findUserByAccountAndPassword(user.getAccount(),user.getPassword()));
    }

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
    @PostMapping(value = "updateUser")
    public ResultMap updateUser(@RequestBody User user){
        return new ResultMap(userService.updateUser(user));
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
     * 根据用户ID查询用户
     * @return
     */
    @GetMapping(value = "findOne")
    public ResultMap findOne(Long id){
        return new ResultMap(userService.findById(id));
    }

    /**
     * 分页条件查找用户
     * @param user
     * @param pageable
     * @return
     */
    @PostMapping(value = "findUserByPage")
    public ResultMap findUserByPage(@RequestBody(required = false) User user,@PageableDefault(sort = {"id"},value = 15, direction = Sort.Direction.DESC) Pageable pageable){
        return new ResultMap(userService.findUserByPage(user,pageable));
    }

}
