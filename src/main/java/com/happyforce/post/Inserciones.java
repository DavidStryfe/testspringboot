package com.happyforce.post;


import com.happyforce.objetos.Comment;
import com.happyforce.services.CommentInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

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


    @RequestMapping(path="/insertarcomentario")
    boolean insertarComentario(@RequestBody Map<String, String> comentario) {

        String text = comentario.get("text");
        String user = comentario.get("user");
        java.sql.Timestamp date = new Timestamp(System.currentTimeMillis());

        Comment comment= new Comment(text, user, date);

        boolean insertado = commentI.insertComment(comment);

        return insertado;
    }

    /*@Autowired
    private CommentInteraction commentInteractionI;*/


}