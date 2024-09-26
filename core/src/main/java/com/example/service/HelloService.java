package com.example.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class HelloService {

    public String giveAnswer(final String name) {

        log.info("An INFO Message");


        return "Hello and greetings to " + name;
    }
}
