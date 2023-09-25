package com.example.main.services;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

@Service
@ApplicationScope
public class SuccessLoginCountService {
    private int count;
    public void increment(){
        count++;
    }
    public int getCount() {
        return count;
    }
}
