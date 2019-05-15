package com.happyforce.services;

import com.happyforce.objetos.CommentInteraction;

public interface CommentInteractionInt {

    public int getCommentLikes(int idComment);

    public int getCommentDislikes(int idComment);

    public boolean updateCommentInteractions(CommentInteraction like);

}
