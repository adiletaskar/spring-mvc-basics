package com.example.main.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoginRequestTimeAspect {
    private double startTime;

    @Before("@annotation(ToLog)")
    public void before(JoinPoint joinPoint) {
        startTime = System.currentTimeMillis();
    }

    @After("@annotation(ToLog)")
    public void after(JoinPoint joinPoint) {
        double endTime = System.currentTimeMillis();
        double executionTime = endTime - startTime;
        System.out.println("Method executed in " + executionTime + " ms");
    }
}
