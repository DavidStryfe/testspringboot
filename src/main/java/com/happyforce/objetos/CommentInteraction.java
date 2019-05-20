package com.happyforce.objetos;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "commentinteraction")
public class CommentInteraction {

    private String userName;
    private int idComment;
    private String kindInteraction;

    public CommentInteraction(String userName, int idComment, String kindInteraction) {
        this.userName = userName;
        this.idComment = idComment;
        this.kindInteraction = kindInteraction;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getIdComment() {
        return idComment;
    }

    public void setIdComment(int idComment) {
        this.idComment = idComment;
    }

    public String getKindInteraction() {
        return kindInteraction;
    }

    public void setKindInteraction(String kindInteraction) {
        this.kindInteraction = kindInteraction;
    }
}
