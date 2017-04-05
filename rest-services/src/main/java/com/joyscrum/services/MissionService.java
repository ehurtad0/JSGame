package com.joyscrum.services;

import com.joyscrum.impl.MissionImpl;
import com.joyscrum.models.Mission;
import com.joyscrum.models.ToID;
import org.bson.types.ObjectId;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Jorge Mota
 * on 4/4/17.
 */
@Path("/mission")

public class MissionService {
    @Inject
    MissionImpl service;

    @GET
    @Path("/{userId}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Mission> listPlayers(@PathParam("userId") String  userId, @QueryParam ("rolId")String rolId) {
        return service.listMissions(new ObjectId(userId),new ObjectId(rolId));
    }

}
