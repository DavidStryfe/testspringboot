package com.happyforce.get;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.happyforce.objetos.Comment;
import com.happyforce.objetos.CommentInteraction;
import com.happyforce.services.CommentInt;
import com.happyforce.services.CommentInteractionInt;
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
import java.util.LinkedList;
import java.util.List;


@Controller
public class Consultas {

    @Autowired
    private CommentInt commentI;

    @Autowired
    private CommentInteractionInt commentInteractionI;

    @RequestMapping(path="/comentarios")
    @ResponseBody
    ResponseEntity<List<Comment>> comentarios() {

        List<Comment> listaComentariosSinInteracciones = commentI.listaComentarios();
        List<Comment> listaComentarios = new LinkedList<>();

        for (int i = 0; i < listaComentariosSinInteracciones.size(); i++) {
            Comment comentario = listaComentariosSinInteracciones.get(i);

            int numLikesComentario = commentInteractionI.getCommentLikes(comentario.getIdComment());
            int numDislikesComentario = commentInteractionI.getCommentDislikes(comentario.getIdComment());

            comentario.setNumLikes(numLikesComentario);
            comentario.setNumDislikes(numDislikesComentario);

            listaComentarios.add(comentario);
        }

        HttpHeaders responseHeaders = new HttpHeaders();
        List<MediaType> medias = new ArrayList<>();
        medias.add(MediaType.ALL);
        responseHeaders.setAccept(medias);
        return new ResponseEntity<List<Comment>>(listaComentarios, responseHeaders, HttpStatus.OK);
    }

}