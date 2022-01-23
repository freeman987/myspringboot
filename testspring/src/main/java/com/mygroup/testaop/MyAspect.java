package com.mygroup.testaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @ClassName: MyAspect
 * @Description:
 * @Author 吴小田
 * @Date 2021/12/22
 * @Version 1.0
 */
@Aspect
@Component
public class MyAspect {
    @Pointcut("execution(* com.mygroup.testaop.IndexDaoImpl1.*(..))")
    public void xxx(){
    }

    @Pointcut("args(java.lang.String)")
    public void yyy(){
    }

    @Pointcut("this(com.mygroup.testaop.IndexDao)")
    public void zzz(){
    }

    @Pointcut("target(com.mygroup.testaop.IndexDao)")
    public void uuu(){
    }

    //@Before("zzz()")
    @Before("uuu()")
    //@Before("xxx()&&!yyy()")
    public void log0(JoinPoint jp){
        System.out.println("yyy");

    }

    @Before("xxx()")
    public void log1(JoinPoint jp){
        System.out.println("before");

    }

    @After("xxx()")
    public void log2(){
        System.out.println("after");
    }

    @AfterReturning(returning = "object", pointcut = "xxx()")
    public void log3(Object object){
//        System.out.println(object.toString());
        //
    }





//    @Autowired
//    private EntityManager entityManager;
//
//    /**
//     * 调用controller包下的任意类的任意方法时均会调用此方法
//     */
//    @Around("execution(* com.company.controller.*.*(..))")
//    public Object run1(ProceedingJoinPoint joinPoint) throws Throwable {
//        //获取方法参数值数组
//        Object[] args = joinPoint.getArgs();
//        //得到其方法签名
//        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
//        //获取方法参数类型数组
//        Class[] paramTypeArray = methodSignature.getParameterTypes();
//        if (EntityManager.class.isAssignableFrom(paramTypeArray[paramTypeArray.length - 1])) {
//            //如果方法的参数列表最后一个参数是entityManager类型，则给其赋值
//            args[args.length - 1] = entityManager;
//        }
//        logger.info("请求参数为{}",args);
//        //动态修改其参数
//        //注意，如果调用joinPoint.proceed()方法，则修改的参数值不会生效，必须调用joinPoint.proceed(Object[] args)
//        Object result = joinPoint.proceed(args);
//        logger.info("响应结果为{}",result);
//        //如果这里不返回result，则目标对象实际返回值会被置为null
//        return result;
//    }
//
//    @Pointcut("execution(* com.company.controller.*.*(..))")
//    public void pointCut2() {}
//
//    @Around("pointCut2()")
//    public Object run2(ProceedingJoinPoint joinPoint) throws Throwable {
//        //获取方法参数值数组
//        Object[] args = joinPoint.getArgs();
//        //得到其方法签名
//        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
//        //获取方法参数类型数组
//        Class[] paramTypeArray = methodSignature.getParameterTypes();
//        if (EntityManager.class.isAssignableFrom(paramTypeArray[paramTypeArray.length - 1])) {
//            //如果方法的参数列表最后一个参数是entityManager类型，则给其赋值
//            args[args.length - 1] = entityManager;
//        }
//        logger.info("请求参数为{}",args);
//        //动态修改其参数
//        //注意，如果调用joinPoint.proceed()方法，则修改的参数值不会生效，必须调用joinPoint.proceed(Object[] args)
//        Object result = joinPoint.proceed(args);
//        logger.info("响应结果为{}",result);
//        //如果这里不返回result，则目标对象实际返回值会被置为null
//        return result;
//    }



}
