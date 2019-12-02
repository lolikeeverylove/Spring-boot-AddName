package com.example.sweater.domain;

import javax.persistence.*;

@Entity
public class Message {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String text;
    private String tag;
    //одному пользователю несколько сообщений, чтобы не создавалось много юзеров с одинаковыми никами
    //fetch егер означает что мы хотим инфу об авторе получать вместе с сообщением
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="user_id")//чтобы называлось юзер айди это поле а не автор айди
    private User author;

    public Message() {
    }

    public Message(String text, String tag, User user) {//выводим сообщение: ник текст и тэг
        this.author =user;
        this.text = text;
        this.tag = tag;
    }
    public String getAuthorName(){//проверка на наличие автора
        return author!=null? author.getUsername() : "<none>";
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }


    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
}
