package com.zzcedu.log;

import lombok.extern.java.Log;
import org.aspectj.lang.ProceedingJoinPoint;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 方面组件封装共同逻辑，与业务主要逻辑不具有相关性
 * 前置通知before，在目标组件执行之前优先执行前置通知
 * 后置通知：after-returning后置通知
 * 在目标组件执行之后执行后置通知
 * 最终通知：after  不管有没有异常都要进行通知
 * 环绕通知：around  围绕目标组件进行前中后的通知
 * 异常通知：throw  目标组件有异常就通知
 */
@Log
public class OperationLogger {
    //前置通知
    public void logger(){
        log.info("这个是方面组件的前置通知");

    }
    //后置通知
    public void logger1(){
        System.out.println("这是方面组件的后置通知");
    }
    //异常通知
    public void logger2( Exception e){
        System.out.println(e.getMessage());
        log.warning("这是方面组件的异常通知");
    }
    //最终通知
    public void logger3(){
        System.out.println("这是方面组件的最终通知");
    }
    //环绕通知
    public Object logger4(ProceedingJoinPoint p) throws Throwable {
        //目标组件的类名
        String className = p.getTarget().getClass().getName();
        //调用的方法
        String methodName = p.getSignature().getName();
        //当前系统时间
        String now = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
        //拼接日志信息
        String msg = "XXX用户在"+now+"执行了"+className+"类的"+methodName+"方法";
        log.info(msg);
        //执行目标组件方法
        Object proceed = p.proceed();//执行hello方法
        //在调用目标组件业务方法后也可以做一些逻辑
        log.warning("调用目标组件业务方法后");
        return proceed;
    }
}
