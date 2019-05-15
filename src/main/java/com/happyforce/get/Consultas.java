package com.happyforce.get;

import com.happyforce.objetos.Comment;
import com.happyforce.services.CommentInt;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @RequestMapping("/comentarios")
    @ResponseBody
    JSONObject comentarios() throws JSONException {
        JSONObject json = new JSONObject();

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

        json.put("comentarios", jsonComentarios);

        return json;
    }

}