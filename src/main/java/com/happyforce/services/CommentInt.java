package com.happyforce.services;

import com.happyforce.objetos.Comment;

import java.util.List;

public interface CommentInt {

    public List<Comment> listaComentarios();

    public boolean insertComment(Comment comentario);

}
