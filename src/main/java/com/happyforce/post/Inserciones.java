package com.happyforce.post;


import com.happyforce.objetos.Comment;
import com.happyforce.objetos.CommentInteraction;
import com.happyforce.services.CommentInt;
import com.happyforce.services.CommentInteractionInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.Map;

@Controller
public class Inserciones {

    @Autowired
    private CommentInt commentI;

    @Autowired
    private CommentInteractionInt commentInteractionI;

    @RequestMapping(path = "/insertarcomentario")
    @ResponseBody
    boolean insertarComentario(@RequestBody Map<String, String> comentario) {

        String text = comentario.get("text");
        String user = comentario.get("user");
        java.sql.Timestamp date = new Timestamp(System.currentTimeMillis());

        Comment comment = new Comment(text, user, date);

        boolean insertado = commentI.insertComment(comment);

        return insertado;
    }

    @RequestMapping(path = "/insertarinteraccioncomentario/{user}/{idcomment}/{kind}")
    @ResponseBody
    boolean insertarInteraccionComentario(
            @PathVariable String user,
            @PathVariable int idcomment,
            @PathVariable String kind) {
        CommentInteraction commentInteraction = new CommentInteraction(user, idcomment, kind);

        boolean insertado = commentInteractionI.updateCommentInteractions(commentInteraction);

        return insertado;
    }


}