package com.happyforce.post;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Inserciones {

    @RequestMapping("/posttest")
    @ResponseBody
    String home() {
        return "HolaMundo POST";
    }

}