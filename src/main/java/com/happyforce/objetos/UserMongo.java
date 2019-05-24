package com.happyforce.objetos;

import org.springframework.data.annotation.Id;

public class UserMongo {

    @Id
    private String name;
    private String password;

    public UserMongo(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserMongo{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
