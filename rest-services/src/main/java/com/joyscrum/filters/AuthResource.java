package com.joyscrum.filters;


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

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public Response auth(@FormParam("token") String token,@HeaderParam("Origin") String origin) {
      //  System.out.println("Authenticated user: " + sctx.getUserPrincipal().getName());

        //this.sctx = sctx;
       // String authenticatedUser = sctx.getUserPrincipal().getName();
        //System.out.println(origin);
        Player player = service.logonPlayer(token,origin);

        if (player ==null){
            throw new ForbiddenException("Token Inválido");//NotAuthorizedException("Token inválido");

        }
        Response resp = Response.ok( " authenticated")
                .header("jwt", JWTokenUtility.buildJWT(token))
                .entity(player)
                .build();

        return resp;
    }

}