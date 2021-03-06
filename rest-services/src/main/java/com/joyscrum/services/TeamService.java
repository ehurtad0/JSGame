package com.joyscrum.services;

import com.joyscrum.impl.TeamImpl;
import com.joyscrum.models.Team;
import com.webcohesion.enunciate.metadata.rs.TypeHint;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;


/**
 * Api para todo lo relacionado a equipos, creación , búsqueda, modificaciones, puntajes, etc/
 **/

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
    @Path("/find/{filter}")
    @Produces({MediaType.APPLICATION_JSON})
    @TypeHint(Team.class)
    public List<Team> findTeams(@PathParam("filter") String teamName) {
        return service.list(teamName);
    }
}
