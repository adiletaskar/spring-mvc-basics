package com.example.main.services;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.Metrics;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

@Service
@ApplicationScope
public class LoginCountService {
    private final Counter count;

    public LoginCountService() {
        // Создаем счетчик при инициализации сервиса
        this.count = Metrics.counter("login_count");
    }

    public void increment() {
        // Инкрементируем счетчик
        count.increment();
    }

    public Counter getCount() {
        return this.count;
    }
}
