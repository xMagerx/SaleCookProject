package com.hipasserby.entity;

import javax.persistence.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class Message implements Comparable<Message> {

    private Date dateOfCreating = new Date();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(columnDefinition="LONGVARCHAR",length = 1500)
    private String text;

    @ManyToOne
    private Dialog dialog;

    @ManyToOne()
    private User author;

    private boolean isRead=false;

    public Message() {
    }

    public Message(Date dateOfCreating, String text, Dialog dialog, User author) {
        this.dateOfCreating = dateOfCreating;
        this.text = text;
        this.dialog = dialog;
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Dialog getDialog() {
        return dialog;
    }

    public void setDialog(Dialog dialog) {
        this.dialog = dialog;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Date getDateOfCreating() {
        return dateOfCreating;
    }

    public void setDateOfCreating(Date dateOfCreating) {
        this.dateOfCreating = dateOfCreating;
    }

    public boolean getIsRead() {
        return isRead;
    }

    public void setIsRead(boolean read) {
        isRead = read;
    }

    @Override
    public int compareTo(Message message) {
        return id.compareTo(message.id);
    }
}
