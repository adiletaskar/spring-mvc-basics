package com.example.main.services;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

@Service
@ApplicationScope
public class SuccessLoginCountService {
    private final Counter count ;
    public SuccessLoginCountService(){
        this.count = Metrics.counter("success_login_count");
    }
    public void increment(){
        count.increment();
    }
    public Counter getCount() {
        return count;
    }
}
