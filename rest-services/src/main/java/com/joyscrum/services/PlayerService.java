package com.joyscrum.services;

import com.joyscrum.impl.PlayerImpl;
import com.joyscrum.models.Player;
import com.joyscrum.models.ToID;
import org.bson.types.ObjectId;


import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


/**
 * Created by Jorge Mota
 * on 3/24/17.
 */

@Path("/player")
public class PlayerService {
    @Inject
    PlayerImpl service;

    @GET
    @Path("/")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Player> listPlayers() {
        return service.listPlayers();
    }


    @POST
    @Path("/validate")
    @Produces({MediaType.APPLICATION_JSON})
    public Player logonPlayer(@FormParam("token") String token) {
        return service.logonPlayer(token);
    }

    @POST
    @Path("/setTeam/{playerId}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response setTeam(@PathParam("playerId") String userId, ToID teamId) {
        if (service.updateTeam(new ObjectId(userId),new ObjectId(teamId.getHexString()))){
            return Response.ok().build();

        }else{
            return Response.status(406).build();
        }
    }
    @POST
    @Path("/setRol/{playerId}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response setRol(@PathParam("playerId") String userId, ToID rolId) {
        if (service.updateRol(new ObjectId(userId),new ObjectId(rolId.getHexString()))){
            return Response.ok().build();

        }else{
            return Response.status(406).build();
        }
    }

}
