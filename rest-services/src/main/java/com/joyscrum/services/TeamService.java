package com.joyscrum.services;

import com.joyscrum.impl.TeamImpl;
import com.joyscrum.models.Team;
import com.webcohesion.enunciate.metadata.rs.TypeHint;

import javax.inject.Inject;
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
    @TypeHint(Team.class)
    public List<Team> listTeams() {
        return service.list();
    }


    @PUT
    @Path("/update/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @TypeHint(Team.class)
    public Team logonPlayer(Team team, @PathParam("id") String id) {
        return service.update(team, id);
    }

    @GET
    @Path("/find/{name}")
    @Produces({MediaType.APPLICATION_JSON})
    @TypeHint(Team.class)
    public List<Team> findTeams(@PathParam("name") String teamName) {
        return service.list(teamName);
    }
}
