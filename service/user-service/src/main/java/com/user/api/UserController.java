package com.user.api;

import com.general.ResultMap;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

/**
 * @author lvchao
 * @date 2018/6/13
 */
@RestController
@RequestMapping(value = "user")
public class UserController {

    @PostMapping(value = "hello")
    public ResultMap hello(@RequestBody String message){
        String str = "机会已经给你了，你自己不争气。";
        return new ResultMap(str);
    }

}
