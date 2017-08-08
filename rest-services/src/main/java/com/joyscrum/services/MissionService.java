package com.joyscrum.services;

import com.joyscrum.impl.MissionImpl;
import com.joyscrum.models.Mission;
import com.joyscrum.models.MissionPlayer;
import com.joyscrum.models.Player;
import com.webcohesion.enunciate.metadata.rs.TypeHint;
import org.bson.types.ObjectId;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 *
 * Api para todo lo relacionado con misiones, listado, puntaje, etc
 */

@Path("/mission")
public class MissionService {
    @Inject
    MissionImpl service;

    /**
     * Obtiene un listado de Misiones disponibles para un usuario basado en el rol asignado.
     *
     * @param userId PK del Usuario
     * @return Lista de Misiones
     */
    @GET
    @Path("/{userId}")
    @Produces({MediaType.APPLICATION_JSON})
    @TypeHint(Mission.class)
    public List<Mission> listMissions(@PathParam("userId") String userId) {
        return service.listMissionsByRol(new ObjectId(userId));
    }

    @GET
    @Path("/score/{userId}")
    @Produces({MediaType.APPLICATION_JSON})
    @TypeHint(MissionPlayer.class)
    public List<MissionPlayer> listMissionscore(@PathParam("userId") String userId) {
      //  return service.listMissionsByRol(new ObjectId(userId));
        return service.listMissionPointsByPlayer(new ObjectId(userId));
    }

    /**
     * Asigna una misión a un usuario
     *
     * @param userId
     * @param missionId debe indicar los ancestros separados por coma PK_MisionPrimara,Pk_MisionSecundaria,PK_Misionfinal
     * @return
     * @HTTP 406 si no es posible asignar la misión al usuario
     */
    @PUT
    @Path("/assign/{userId}")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response assignMission(@PathParam("userId") String userId, String missionId) {
        Player player = service.assignMission(new ObjectId(userId), missionId);
        if (player != null) {
            return Response.ok().entity(player).build();
        } else {
            return Response.status(406).build();
        }
    }

    /**
     * Permite incrementar el progreso de la tarea actualmente asignada.
     * @param userId
     * @param progress
     * @return
     */
    @POST
    @Path("/updateProgress/{userId}")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response updateProgress(@PathParam("userId") String userId, double progress) {
        MissionPlayer mission = service.incrementProgressMission(new ObjectId(userId), progress);
        if (mission != null) {
            return Response.ok().entity(mission).build();

        } else {
            return Response.status(406).build();
        }
    }
    @GET
    @Path("/progress/{userId}")
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response getProgressCurrentMission(@PathParam("userId") String userId) {
        List<MissionPlayer> mission = service.getProgressMission(new ObjectId(userId));
        if (mission != null) {
            return Response.ok().entity(mission).build();

        } else {
            return Response.status(406).build();
        }
    }
}
