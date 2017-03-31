package com.joyscrum.services;

import com.joyscrum.impl.TeamImpl;
import com.joyscrum.models.Team;

import javax.inject.Inject;
import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


/**
 * Created by Jorge Mota
 * on 3/24/17.
 */

@Path("/team")
public class TeamService {
    @Inject
    TeamImpl service;

    @GET
    @Path("/")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Team> listPlayers() {
        return service.list();
    }


    @PUT
    @Path("/update/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Team logonPlayer(Team team ,@PathParam("id") String id) {
        return service.update(team,id);
    }

}
