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
 * Created by Jorge Mota
 * on 3/24/17.
 */

@Path("/player")
public class PlayerService {
    @Inject
    PlayerImpl service;

    /**
     * Obtiene una lista de toda la tabla jugadores
     * Esta no existirá en producción.
     * @return
     */
    @Deprecated
    @GET
    @Path("/")
    @Produces({MediaType.APPLICATION_JSON})
    @TypeHint(Player.class)
    public List<Player> listPlayers() {
        return service.listPlayers();
    }

    /**
     * Permite probar el login de un usuario, sin Generar el JWT token
     *
     * @param token
     * @param origin
     * @return El objeto Jugador del usuario que está iniciando sesión
     */
    @POST
    @Path("/validate")
    @Produces({MediaType.APPLICATION_JSON})
    @TypeHint(Player.class)
    public Player logonPlayer(@FormParam("token") String token, @HeaderParam("Origin") String origin) {

        return service.logonPlayer(token, origin);
    }

    /**
     *  Establece un equipo al jugador
     *  @HTTP 406 si no es posible asignar el equipo.
     * @param userId
     * @param teamId
     * @return @HTTP 200 si todo resulta bien.
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
     *
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

    @GET
    @Path("/mission/{playerId}")
    @Produces({MediaType.APPLICATION_JSON})
    @TypeHint(MissionPlayer.class)
    public MissionPlayer getCurrentMission(@PathParam("playerId") String userId) {
        return service.getCurrentMission(userId);
    }

    @POST
    @Path("/mission/{playerId}/update")
    @TypeHint(MissionPlayer.class)
    @Produces({MediaType.APPLICATION_JSON})
    public MissionPlayer updateCurrentMission(@PathParam("playerId")String userId){
    return null;
    }
}