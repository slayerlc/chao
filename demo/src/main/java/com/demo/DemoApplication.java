package com.demo;

import com.common.TestUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(DemoApplication.class);
        springApplication.run(args);
        Set setListeners = springApplication.getListeners();
        analyze(setListeners);
        new TestUtil().test();
    }

    public static void analyze(Set set){
        Iterator i = set.iterator();
        while(i.hasNext()){
            Object obj = i.next();
            System.out.println(obj);
        }
    }
}
