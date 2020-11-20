package com.shone.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//进行服务提供时的测试控制器
@RestController
@RequestMapping("/Hello")
public class TestController {

    @RequestMapping("/World")
    public String helloWord(String s){
        System.out.println("传入的值为：" + s);
        return "传入的值为：" + s;
    }
}
