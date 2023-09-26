package com.example.main.services;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.Metrics;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

@Service
@ApplicationScope
public class ActiveUsersService {
    private final Gauge gauge;

    public ActiveUsersService() {
        this.gauge = Gauge.builder("active_users_count", this, service -> service.getCount())
                .register(Metrics.globalRegistry);
    }

    private int count = 0;

    public void increment() {
        count++;
    }

    public void decrement() {
        count--;
    }

    public int getCount() {
        return count;
    }
}
