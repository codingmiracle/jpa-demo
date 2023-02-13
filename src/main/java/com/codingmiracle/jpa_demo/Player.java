package com.codingmiracle.jpa_demo;


import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.persistence.*;

@Entity
@NamedQuery(name = "Player.findAll",
        query = "SELECT s FROM Player s")
@Table(name = "Player")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long playerid;
    private String name;

    public Player() {}

    public Player(String name) {
        this.setName(name);
    }

    public Player(Long id) {
        this.setPlayerid(id);
    }

    public long getPlayerid() {
        return playerid;
    }

    public void setPlayerid(long playerid) {
        this.playerid = playerid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static boolean isPlayerId(String value) {
        return value.matches("^[0-9]*$");
    }
}
