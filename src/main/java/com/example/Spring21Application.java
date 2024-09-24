package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@Profile("!dev")
public class Spring21Application {

    public static void main(String[] args) {
        SpringApplication.run(Spring21Application.class, args);
    }

}
