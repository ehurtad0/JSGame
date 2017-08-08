package com.joyscrum.services;

import com.joyscrum.impl.PlayerImpl;
import com.joyscrum.models.MissionPlayer;
import com.joyscrum.models.Player;
import com.joyscrum.models.ToID;
import com.webcohesion.enunciate.metadata.rs.TypeHint;
import org.bson.types.ObjectId;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


/**
 * Api para todo lo relacionado al jugador, perfil, asignar rol, equipo, etc.
 */

@Path("/player")
public class PlayerService {
    @Inject
    PlayerImpl service;

    /**
     * Retorna el perfil del jugador actualizado
     *
     * @return
     */
    @GET
    @Path("/profile/{userId}")
    @Produces({MediaType.APPLICATION_JSON})
    @TypeHint(Player.class)
    public Player getProfile(@PathParam("userId")String userId) {
        return service.getProfile(userId);
    }

    /**
     * Permite probar el login de un usuario, sin Generar el JWT token
     *ajajpor qu
     * @param token
     * @param origin
     * @return El objeto Jugador del usuario que está iniciando sesión
     */
    @POST
    @Path("/validate")
    @Produces({MediaType.APPLICATION_JSON})
    @TypeHint(Player.class)
    public Player logonPlayer(@FormParam("token") String token, @HeaderParam("Origin") String origin) {

        //     return service.logonPlayer(token, origin);
        return null;
    }

    /**
     * Establece un equipo al jugador
     *
     * @param userId
     * @param teamId
     * @return @HTTP 200 si todo resulta bien.
     * @HTTP 406 si no es posible asignar el equipo.
     */
    @POST
    @Path("/setTeam/{playerId}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response setTeam(@PathParam("playerId") String userId, ToID teamId) {
        if (service.updateTeam(new ObjectId(userId), new ObjectId(teamId.getHexString()))) {
            return Response.ok().build();

        } else {
            return Response.status(406).build();
        }
    }

    /**
     * @param userId
     * @param rolId
     * @return
     */
    @POST
    @Path("/setRol/{playerId}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response setRol(@PathParam("playerId") String userId, ToID rolId) {
        if (service.updateRol(new ObjectId(userId), new ObjectId(rolId.getHexString()))) {
            return Response.ok().build();

        } else {
            return Response.status(406).build();
        }
    }

    /**
     * Realiza cambios en el perfil del usuario.
     * Retorna @HTTP 406 si ocurre un error al modificar el perfil
     *
     * @param userId Id De Usuario
     * @param player Objeto Player con los cambios a realizar
     * @return
     */
    @POST
    @Path("/updatePlayer/{playerId}")
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response updatePlayerInfo(@PathParam("playerId") String userId, Player player) {
        if (service.updatePlayer(new ObjectId(userId), player)) {
            return Response.ok().build();
        } else {
            return Response.status(406).build();
        }
    }

    /**
     * Retorna la  jerarquía de la misión activa del usuario indicado en userId
     * Retorna Primaria/Secundaria/etc
     *
     * @param userId
     * @return
     */
    @GET
    @Path("/mission/{playerId}")
    @Produces({MediaType.APPLICATION_JSON})
    @TypeHint(MissionPlayer.class)
    public List<MissionPlayer> getCurrentMission(@PathParam("playerId") String userId) {
        List<MissionPlayer> currentMission = service.getCurrentMission(userId);
        if (currentMission==null){
            return null;//Response.status(406).build();
        }
        else{
            return currentMission;
        }
    }

    /**
     * Permite cambiar la misión actual del usuario indicado en userId
     *
     * @param userId
     * @return
     */
    @POST
    @Path("/setMission/{playerId}")
    @TypeHint(MissionPlayer.class)
    @Produces({MediaType.APPLICATION_JSON})
    public MissionPlayer updateCurrentMission(@PathParam("playerId") String userId,ToID missionId) {
        return service.updateCurrentMission(userId,missionId.getHexString());
    }
}