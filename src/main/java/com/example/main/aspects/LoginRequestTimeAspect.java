package com.example.main.aspects;

import io.micrometer.core.instrument.Metrics;
import io.micrometer.core.instrument.Timer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
@Aspect
@Component
public class LoginRequestTimeAspect {
    private Timer.Sample sample;

    @Before("@annotation(ToLog)")
    public void before(JoinPoint joinPoint) {
        sample = Timer.start(Metrics.globalRegistry);
    }

    @After("@annotation(ToLog)")
    public void after(JoinPoint joinPoint) {
        if (sample != null) {
            Timer timer = Timer.builder("login_request_execution_time")
                    .description("Execution time of login request")
                    .register(Metrics.globalRegistry);
            sample.stop(timer);
        }
    }
}
