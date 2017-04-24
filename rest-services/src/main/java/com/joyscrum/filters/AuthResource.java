package com.joyscrum.filters;


import com.joyscrum.auth.GoogleAuth;
import com.joyscrum.auth.TrelloAuth;
import com.joyscrum.impl.PlayerImpl;
import com.joyscrum.models.Player;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by Jorge Mota
 * on 3/28/17.
 */

@Path("AUTH")
public class AuthResource {
    @Inject
    PlayerImpl service;
    //@Context
    //SecurityContext sctx;
    @Inject
    GoogleAuth googleAuth;
    @Inject
    TrelloAuth trelloAuth;

    @Deprecated
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public Response auth(@FormParam("token") String token, @HeaderParam("Origin") String origin) {
        Player player = googleAuth.logonPlayer(origin, token);
        if (player == null) {
            throw new ForbiddenException("Token Inválido");//NotAuthorizedException("Token inválido");
        }
        Response resp = Response.ok(" authenticated")
                .header("jwt", JWTokenUtility.buildJWT(token))
                .entity(player)
                .build();
        return resp;
    }

    /**
     * Método para iniciar sesión vía Google
     * @param token Token devuelto por el api de google
     * @param origin
     * @return
     */
    @Path("/google")
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public Response authGoogle(@FormParam("token") String token, @HeaderParam("Origin") String origin) {
        Player player = googleAuth.logonPlayer(origin, token);
        if (player == null || !player.isEsActivo()) {
            throw new ForbiddenException("Token Inválido");//NotAuthorizedException("Token inválido");
        }
        return Response.ok(" authenticated")
                .header("jwt", JWTokenUtility.buildJWT(token))
                .entity(player)
                .build();
    }

    /**
     * Método para iniciar sesión via Trello
     * @param token Token devuelto por Trello.token()
     * @param origin
     * @return
     */
    @Path("/trello")
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public Response authTrello(@FormParam("token") String token, @HeaderParam("Origin") String origin) {
        Player player = trelloAuth.logonPlayer(origin, token);
        if (player == null || !player.isEsActivo()) {
            throw new ForbiddenException("Token Inválido");//NotAuthorizedException("Token inválido");
        }
        return Response.ok(" authenticated")
                .header("jwt", JWTokenUtility.buildJWT(token))
                .entity(player)
                .build();
    }

}