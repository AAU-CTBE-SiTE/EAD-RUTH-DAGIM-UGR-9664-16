package com.site.actor_management.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Pointcut("execution(* com.site.actor_management.controller.*.*(..))")
    public void controllerMethods() {
    }

    @Before("controllerMethods()")
    public void before(JoinPoint joinPoint) {
        System.out.println("Before: " + joinPoint.getSignature().getName());
    }

    @After("controllerMethods()")
    public void after(JoinPoint joinPoint) {
        System.out.println("After: " + joinPoint.getSignature().getName());
    }

    @AfterReturning(pointcut = "controllerMethods()", returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("After returning: " + result);
    }

    @AfterThrowing(pointcut = "controllerMethods()", throwing = "error")
    public void afterThrowing(JoinPoint joinPoint, Exception error) {
        System.out.println("After throwing: " + error.getMessage());
    }

    @Around("controllerMethods()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("Around: start");
        Object result = joinPoint.proceed();
        System.out.println("Around: end");
        return result;
    }
}