package com.scrobblebots.scrobblebotapi.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "\"User\"")
public class User {
    @Id
    @Getter @Setter
    private String discordUsername;
    @Getter @Setter
    private String lastFmUsername;

    public User(String discordUsername, String lastFmUsername) {
        this.discordUsername = discordUsername;
        this.lastFmUsername = lastFmUsername;
    }

    public User() {
    }
}
