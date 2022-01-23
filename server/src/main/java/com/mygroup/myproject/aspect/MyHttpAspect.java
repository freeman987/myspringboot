package com.mygroup.myproject.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

//@Aspect
//@Component
public class MyHttpAspect {
//    @Before("execution(public * com.mygroup.myproject.controller.HelloController.*(..))")
//    public void log2(){
//        System.out.println("hhhhhhhhh");
//    }
//
//    @After("execution(public * com.mygroup.myproject.controller.HelloController.*(..))")
//    public void log3(){
//        System.out.println("iiiiiiiiii");
//    }






//    @Pointcut("execution(public * com.mygroup.myproject.controller.HelloController.*(..))")
//    public void xxx(){
//    }
//
//    @Before("xxx()")
//    public void log(JoinPoint jp){
//        ServletRequestAttributes attributes=(ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request= attributes.getRequest();
//        StringBuffer url=request.getRequestURL();
//        String method=request.getMethod();
//        String addr=request.getRemoteAddr();
//        int remoteport=request.getRemotePort();
//        int localport=request.getLocalPort();
//        int serverport=request.getLocalPort();
//
//        System.out.println("url:"+url);
//        System.out.println("method:"+method);
//        System.out.println("addr:"+addr);
//        System.out.println("remoteport:"+remoteport);
//        System.out.println("localport:"+localport);
//        System.out.println("serverport:"+serverport);
//        System.out.println("method:"+jp.getSignature().getDeclaringTypeName()+"."+jp.getSignature().getName());
//        System.out.println("arguments:"+jp.getArgs());
//
//    }
//
//    @After("xxx()")
//    public void log2(){
//        System.out.println("iiiiiiiii");
//    }
//
//    @AfterReturning(returning = "object", pointcut = "xxx()")
//    public void log3(Object object){
//        System.out.println(object.toString());
//    }

}
