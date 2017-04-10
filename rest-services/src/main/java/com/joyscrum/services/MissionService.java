package com.joyscrum.services;

import com.joyscrum.impl.MissionImpl;
import com.joyscrum.models.Mission;
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
 * on 4/4/17.
 */
@Path("/mission")

public class MissionService {
    @Inject
    MissionImpl service;

    @GET
    @Path("/{userId}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Mission> listPlayers(@PathParam("userId") String userId) {
        return service.listMissionsByRol(new ObjectId(userId));
    }

    @PUT
    @Path("/assign/{userId}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response assignMission(@PathParam("userId") String userId, ToID missionId) {
        Player player = service.assignMission(new ObjectId(userId), new ObjectId(missionId.getHexString()));
        if (player != null) {
            return Response.ok().entity(player).build();
        } else {
            return Response.status(406).build();
        }
    }

}
