package com.card_status.entity;


import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "delivered_exception",uniqueConstraints = @UniqueConstraint(columnNames = {"card_id","user_contact"} ))
public class DeliveredException {
    @Id
    private String id;

    @Column(name = "card_id", unique = true)
    private String card_id;

    @Column(name = "user_contact", unique = true)
    private String user_contact;
    private Timestamp timestamp;
    private String comment;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    public String getUser_contact() {
        return user_contact;
    }

    public void setUser_contact(String user_contact) {
        this.user_contact = user_contact;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
