package com.codingmiracle.jpa_demo.dao;

import com.codingmiracle.jpa_demo.Player;
import jakarta.persistence.EntityManager;

import java.security.InvalidParameterException;
import java.sql.*;

public class PlayerDao {

    public void createPlayer(EntityManager em, String name) {
        Player player = new Player();
        player.setName(name);
        em.getTransaction().begin();
        em.persist(player);
        em.getTransaction().commit();
    }

    public void deletePlayer(EntityManager em, Long id)  {
        em.getTransaction().begin();
        em.remove(new Player(id));
        em.getTransaction().commit();
    }

    public Player queryPlayer(EntityManager em, String query) {
        Player player = null;
        if(Player.isPlayerId(query)) {
            player = em.find(Player.class, new Player(Long.parseLong(query)));
        } else {
            player = em.find(Player.class, new Player(query));
        }
        return player;
    }
}
