package com.example.main.services;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

@Service
@ApplicationScope
public class ActiveUsersService {
    private int count;

    public void increment(){
        count++;
        System.out.println(count);
    }
    public void decrement(){
        count--;
    }
    public int getCount() {
        return count;
    }
}
