package com.happyforce.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@SpringBootApplication(scanBasePackages={ "com.happyforce.services"})
@Configuration
//@ComponentScan({"com.happyforce.get", "com.happyforce.services"})
@ComponentScan({"com.happyforce.controller", "com.happyforce.repository"})
//@ComponentScan({"com.happyforce.get", "com.happyforce.services", "com.happyforce.controller", "com.happyforce.repository"})
@EnableAutoConfiguration
public class TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }

}
