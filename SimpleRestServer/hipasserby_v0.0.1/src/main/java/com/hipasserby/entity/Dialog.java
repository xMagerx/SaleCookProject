package com.hipasserby.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.*;

@Entity
@JsonIgnoreProperties("messages")
public class Dialog{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "USER_DIALOGS",
            joinColumns = @JoinColumn(name = "ID_DIALOG"),
            inverseJoinColumns = @JoinColumn(name = "ID_USER"))
    private List<User> users = new ArrayList<>();

    //    @JsonIgnore
//    @JsonManagedReference
    @JsonBackReference
    @OneToMany(mappedBy = "dialog",fetch = FetchType.LAZY)
    private List<Message> messages = new ArrayList<Message>();


    private Date date;
//    @JsonBackReference
    private String lastMessage;

    private boolean isReadLastMessage;

    private Integer idAuthorOfLastMessage;


    public Dialog() {

    }

    public Dialog(List<User> users, List<Message> messages) {
        this.users = users;
        this.messages = messages;
    }

    public Dialog(List<User> users, List<Message> messages, Date date, String lastMessage) {
        this.users = users;
        this.messages = messages;
//        this.date = date;
//        this.lastMessage = lastMessage;
    }


    public Date getDate() {

//        try {
////            Collections.sort(messages);
//            this.date = messages.get(messages.size() - 1).getDateOfCreating();
//        } catch (ArrayIndexOutOfBoundsException e) {
//            return date;
//        }
//        Date dak = new Date(0);

//        return dak;

        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Message> getMessages() {
        Collections.sort(messages);
        return messages;
    }

    public String getLastMessage() {
//        try {
//            Collections.sort(messages);
//            Message message = messages.get(messages.size() - 1);
//            lastMessage = message.getText();
            return lastMessage;
//        } catch (ArrayIndexOutOfBoundsException e) {
//            return null;
//        }
    }

    public void setLastMessage(String lastMessage) {
        this.lastMessage = lastMessage;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public boolean getIsReadLastMessage() {
        return isReadLastMessage;
    }

    public void setReadLastMessage(boolean readLastMessage) {
        isReadLastMessage = readLastMessage;
    }

    public boolean isReadLastMessage() {
        return isReadLastMessage;
    }

    public Integer getIdAuthorOfLastMessage() {
        return idAuthorOfLastMessage;
    }

    public void setIdAuthorOfLastMessage(Integer idAuthorOfLastMessage) {
        this.idAuthorOfLastMessage = idAuthorOfLastMessage;
    }

    @Override
    public String toString() {
        return "Dialog{" +
                "id=" + id +
                ", users=" + users +
                ", messages=" + messages +
                '}';
    }

//    @Override
//    public int compareTo(Dialog dialog) {
//        return dialog.getDate().compareTo(getDate());
//    }
}
