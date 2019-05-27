package com.happyforce.controller;

import com.happyforce.objetos.UserMongo;
import com.happyforce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UserMongoController {

    @Autowired
    private UserRepository repository;

    @RequestMapping(value = "/usuariosmongo", method = RequestMethod.GET)
    public List<UserMongo> getAllUsers() {
        System.out.println("XXXXX");
        return repository.findAll();
    }

    @RequestMapping(value = "/")
    public String index(){
        System.out.println("Home Page");
        return "index";
    }

}
