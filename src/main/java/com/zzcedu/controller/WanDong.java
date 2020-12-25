package com.zzcedu.controller;

import lombok.extern.java.Log;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Log
@RestController
public class WanDong {
    @RequestMapping("haode.do")
    public String wan(){
        log.info("来了来了");
        return "hello";
    }
}
