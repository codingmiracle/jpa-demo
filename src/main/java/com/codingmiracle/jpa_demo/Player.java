package com.codingmiracle.jpa_demo;


import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.persistence.*;

@Entity
@NamedQuery(name = "Player.findAll",
        query = "SELECT s FROM Player s")
@Table(name = "Player")
public class Player {

    private static int lastid = 0;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)


    private long playerid;
    private String name;
}
