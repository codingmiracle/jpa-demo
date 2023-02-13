package com.codingmiracle.jpa_demo.rest;

import com.codingmiracle.jpa_demo.Player;
import com.codingmiracle.jpa_demo.dao.PlayerDao;
import jakarta.enterprise.context.RequestScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/player")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Transactional
@RequestScoped
public class PlayerRestEndpoint {

    @PersistenceContext
    private EntityManager em;
    PlayerDao playerDao;

    PlayerRestEndpoint() {
        playerDao = new PlayerDao();
    }


    @GET
    @Path("/{player}")
    public Response findPlayer(@PathParam("player") String searchString) {
        playerDao.queryPlayer(em, searchString);
        return Response.ok().build();
    }

    @POST
    @Path("/{playerName}")
    public Response createPlayer(@PathParam("playerName") String name) {
        playerDao.createPlayer(em, name);
        return Response.ok("ok").build();
    }

    @DELETE
    @Path("/{playerId}")
    public Response deletePlayer(@PathParam("playerId") String playerId) {
        playerDao.deletePlayer(em, Long.parseLong(playerId));
        return Response.ok().build();
    }

}
