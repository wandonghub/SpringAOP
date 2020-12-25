package com.zzcedu.log;

import lombok.extern.java.Log;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Log
public class LianXi {
    public void lll(){
    log.info("我是前置通知");
    }
    public void lll1(){
        log.info("我是最终通知");
    }
    public void lll2(){
        log.info("我是后置通知");
    }

}
