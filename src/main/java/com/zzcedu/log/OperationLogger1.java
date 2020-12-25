package com.zzcedu.log;

import lombok.extern.java.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Before:用于声明前置通知
 * @After: 用于声明最终通知
 * @AfterReturning:用于声明后置通知
 * @Around:用于环绕通知
 * @AfterThrowing:用于声明异常通知
 */
@Log
@Component
@Aspect//声明方面组件
public class OperationLogger1 {
    //参数是切入的位置
    @Before("within(com.zzcedu.controller.HelloController)")
    public void logger1(){
        log.info("这是AOP的前置通知");
    }
    @AfterReturning("within(com.zzcedu.controller.HelloController)")
    public void logger2(){
        log.info("这是AOP的后置置通知");
    }
    @After("within(com.zzcedu.controller.HelloController)")
    public void logger3(){
        log.info("这是AOP的最终通知");
    }
    //               切入点
    @AfterThrowing(pointcut = "within(com.zzcedu.controller..*)",throwing = "e")
    public void logger4(Exception e){
        log.warning(e.getMessage());
    }
    @Around("within(com.zzcedu.controller.HelloController)")
    public Object logger5(ProceedingJoinPoint point) throws Throwable {
        //获取类名
        String className = point.getTarget().getClass().getName();
        //获取方法名
        String methodName = point.getSignature().getName();
        String now = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
        String msg = "XXX用户在"+now+"执行了"+className+"类的"+methodName+"方法";
        log.info(msg);
        Object proceed = point.proceed();//代理执行hello方法
        //执行完hello方法后可以有其他操作
        return proceed;
    }
}
