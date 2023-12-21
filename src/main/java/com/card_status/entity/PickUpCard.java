package com.card_status.entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "pickup_card",uniqueConstraints = @UniqueConstraint(columnNames = {"card_id","user_mobile"} ))
public class PickUpCard {

    @Id
    private int id;

    @Column(name = "card_id", unique = true)
    private String card_id;

    @Column(name = "user_mobile",unique = true)
    private String user_mobile;
    private Timestamp timestamp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    public String getUser_mobile() {
        return user_mobile;
    }

    public void setUser_mobile(String user_mobile) {
        this.user_mobile = user_mobile;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
