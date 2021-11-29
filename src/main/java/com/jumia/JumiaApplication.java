package com.jumia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class JumiaApplication {

    public static void main(String[] args) {
        SpringApplication.run(JumiaApplication.class, args);
    }
}