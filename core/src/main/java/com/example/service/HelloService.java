package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
    public String giveAnswer(final String name) {
        return "Hello and greetings to " + name;
    }
}
