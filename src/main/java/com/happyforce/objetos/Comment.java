package com.happyforce.objetos;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement(name = "comment")
public class Comment {

    private int idComment;
    private String text;
    private String userName;
    private java.util.Date date;
    private int numLikes;
    private int numDislikes;

    public Comment(int idComment, String text, String userName, Date date, int numLikes, int numDislikes) {
        this.idComment = idComment;
        this.text = text;
        this.userName = userName;
        this.date = date;
        this.numLikes = numLikes;
        this.numDislikes = numDislikes;
    }

    public Comment(int idComment, String text, String userName, Date date) {
        this.idComment = idComment;
        this.text = text;
        this.userName = userName;
        this.date = date;
    }

    public Comment(String text, String userName, Date date) {
        this.text = text;
        this.userName = userName;
        this.date = date;
    }


    /*web Comment(String userName, String text, Date date) {
        this.userName = userName;
        this.text = text;
        this.date = date;
    }*/

    public int getIdComment() {
        return idComment;
    }

    public void setIdComment(int idComment) {
        this.idComment = idComment;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getNumLikes() {
        return numLikes;
    }

    public void setNumLikes(int numLikes) {
        this.numLikes = numLikes;
    }

    public int getNumDislikes() {
        return numDislikes;
    }

    public void setNumDislikes(int numDislikes) {
        this.numDislikes = numDislikes;
    }
}
