package com.happyforce.get;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class Consultas {

    @RequestMapping("/gettest")
    @ResponseBody
    String home() {
        return "HolaMundo GET Deploy 3";
    }

   /*@RequestMapping("/comentarios")
    @ResponseBody
    JSONObject listaTorneosActuales() throws JSONException {
        JSONObject json = new JSONObject();

        List<CommentTO> listaComentarios = cliente.listaComentarios();

        JSONArray jsonComentarios = new JSONArray();
        for (int i = 0; i < listaComentarios.size(); i++) {
            CommentTO comentario = listaComentarios.get(i);
            JSONObject jsonComentario = new JSONObject();

            jsonComentario.put("idcomment", comentario.getIdComment());
            jsonComentario.put("user", comentario.getUser());
            jsonComentario.put("text", comentario.getText());
            jsonComentario.put("date", comentario.getDate());
            jsonComentario.put("likes", cliente.getCommentLikes(comentario.getIdComment()));
            jsonComentario.put("dislikes", cliente.getCommentDislikes(comentario.getIdComment()));

            jsonComentarios.put(jsonComentario);
        }

        json.put("comentarios", jsonComentarios);

        return json;
    }*/
}