package com.example.ecommercedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class EcommercedemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(EcommercedemoApplication.class, args);
    }

}
