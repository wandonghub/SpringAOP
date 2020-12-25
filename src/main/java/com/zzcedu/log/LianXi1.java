package com.zzcedu.log;

import lombok.extern.java.Log;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
@Log
@Component
@Aspect //声明方面组件   相对于<bean id="operationLogger" class="com.zzcedu.log.OperationLogger"/>
public class LianXi1 {
    //指明要切入的位置
    @Before("within(com.zzcedu.controller.WanDong)")
    public void duoduo(){
    log.info("我是前置通知");
    }
}
