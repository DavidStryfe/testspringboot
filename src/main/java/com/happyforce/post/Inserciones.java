package com.happyforce.post;


import com.happyforce.services.CommentInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class Inserciones {

   /*@Autowired
    private HolaMundo hm;


    @RequestMapping("/posttest")
    @ResponseBody
    String home() {
        return hm.holamundo();
    }*/

    @Autowired
    private CommentInt commentI;

    /*@Autowired
    private CommentInteraction commentInteractionI;*/


}