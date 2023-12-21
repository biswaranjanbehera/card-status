package com.card_status.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.sql.Timestamp;

@Entity
@Table(name = "current_status",uniqueConstraints = @UniqueConstraint(columnNames = {"card_id"} ))
public class CurrentStatus {
    @Id
    private String card_id;
    private Timestamp last_update;
    private String status;

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    public Timestamp getLast_update() {
        return last_update;
    }

    public void setLast_update(Timestamp last_update) {
        this.last_update = last_update;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
