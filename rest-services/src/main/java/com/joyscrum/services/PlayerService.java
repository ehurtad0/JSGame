package com.joyscrum.services;

import com.joyscrum.HelloService;
import com.joyscrum.impl.PlayerImpl;
import com.joyscrum.models.Player;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
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
}
