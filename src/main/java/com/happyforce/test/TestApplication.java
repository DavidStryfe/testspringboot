package com.happyforce.test;

import com.happyforce.objetos.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
@ComponentScan(basePackages="com.happyforce.get")
@ComponentScan(basePackages="com.happyforce.post")
public class TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);

        //ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");



       /* HelloCrunchify hello = (HelloCrunchify) context.getBean("helloCrunchify");
        hello.sayHelloCrunchify();

        ApplicationContext context = new ClassPathXmlApplicationContext("beanshappyforcetest.xml");
        User user = (User) context.getBean("user",User.class);

        System.out.println(user.toString());*/
    }

}
