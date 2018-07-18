/*
package com.demo;

import com.demo.controller.HelloController;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringRunner.class)  //引入spring junit4支持
@SpringBootTest
@WebAppConfiguration       //开启WEB应用的配置 用于模拟servletContext
public class DemoApplicationTests {

    private MockMvc mockMvc;  //用于模拟调用Controller的接口发送请求

    */
/**
     *  Junit在这里初始化对HelloController的模拟
     *//*

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
    }

    @Test
    public void contextLoads() throws Exception {
        //accept 接受请求的数据类型
        mockMvc.perform(MockMvcRequestBuilders.post("/hello/hello").accept(MediaType.APPLICATION_JSON))
        //设置预期返回的状态码
        .andExpect(MockMvcResultMatchers.status().isOk())
        //判断返回的值是否是于期望值相同
        .andExpect(MockMvcResultMatchers.content().string(Matchers.equalToIgnoringCase("hello")));
    }

}
*/
