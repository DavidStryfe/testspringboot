package com.happyforce.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(scanBasePackages={ "com.happyforce"})
@Configuration
//@ComponentScan({"com.happyforce.get", "com.happyforce.services"})
//@ComponentScan({"com.happyforce.get", "com.happyforce.services", "com.happyforce.controller", "com.happyforce.repository"})
@EnableAutoConfiguration
@EnableMongoRepositories(basePackages={ "com.happyforce.repository"})
public class TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }

}
