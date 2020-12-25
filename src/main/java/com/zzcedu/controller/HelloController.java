package com.zzcedu.controller;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 目标组件
 */
@Log
@RestController
public class HelloController {
    @GetMapping("/hello.do")
    public String hello(){
        //前置通知的地方

//        int a = 1/0;
        log.info("信息级别");
        log.warning("警告级别");
        log.info("进来了");
        //后置通知的地方
        return "hello";
    }
}
