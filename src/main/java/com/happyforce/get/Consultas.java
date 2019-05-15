package com.happyforce.get;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.happyforce.objetos.Comment;
import com.happyforce.services.CommentInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Controller
public class Consultas {

    /*@RequestMapping("/gettest")
    @ResponseBody
    String home() {
        return "HolaMundo GET Deploy 3";
    }

    @Autowired
    private HolaMundo hm;

    @RequestMapping("/posttest")
    @ResponseBody
    String home() {
        return hm.holamundo();
    }*/

    @Autowired
    private CommentInt commentI;

   /* @Autowired
    private CommentInteraction commentInteractionI;*/

    @RequestMapping(path="/comentarios")
    @ResponseBody
    ResponseEntity<List<Comment>> comentarios() {

        HttpHeaders responseHeaders = new HttpHeaders();
        List<MediaType> medias = new ArrayList<>();
        medias.add(MediaType.ALL);
        responseHeaders.setAccept(medias);
        return new ResponseEntity<List<Comment>>(commentI.listaComentarios(), responseHeaders, HttpStatus.OK);

       // return commentI.listaComentarios();
        /*ObjectNode objectNode = new
                ObjectNode();

        HashMap<String, String> map = new HashMap<>();
        map.put("key", "value");
        map.put("foo", "bar");
        map.put("aa", "bb");


        List<Comment> listaComentarios = commentI.listaComentarios();

        JSONArray jsonComentarios = new JSONArray();
        for (int i = 0; i < listaComentarios.size(); i++) {
            Comment comentario = listaComentarios.get(i);
            JSONObject jsonComentario = new JSONObject();

            //jsonComentario.put("idcomment", comentario.getIdComment());
            jsonComentario.put("user", comentario.getUserName());
            jsonComentario.put("text", comentario.getText());
            jsonComentario.put("date", comentario.getDate());
            //jsonComentario.put("likes", cliente.getCommentLikes(comentario.getIdComment()));
            //jsonComentario.put("dislikes", cliente.getCommentDislikes(comentario.getIdComment()));

            jsonComentarios.put(jsonComentario);
        }

        //json.put("comentarios", jsonComentarios);

        return map;*/
    }

}