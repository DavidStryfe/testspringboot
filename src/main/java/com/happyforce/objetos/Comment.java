package com.happyforce.objetos;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "comment")
public class Comment {

    private String userName;
    private String text;
    private java.util.Date date;
    private List<CommentInteraction> commentInteractionsList;

    public Comment(String userName, String text, Date date) {
        this.userName = userName;
        this.text = text;
        this.date = date;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "userName='" + userName + '\'' +
                ", text='" + text + '\'' +
                ", date=" + date +
                '}';
    }
}
