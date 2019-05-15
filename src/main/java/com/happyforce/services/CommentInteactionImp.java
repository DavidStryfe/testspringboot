package com.happyforce.services;

import com.happyforce.objetos.CommentInteraction;
import org.springframework.stereotype.Service;

@Service
public class CommentInteactionImp implements CommentInteractionInt{

    @Override
    public int getCommentLikes(int idComment) {
        return 0;
    }

    @Override
    public int getCommentDislikes(int idComment) {
        return 0;
    }

    @Override
    public boolean updateCommentInteractions(CommentInteraction like) {
        return false;
    }
}
