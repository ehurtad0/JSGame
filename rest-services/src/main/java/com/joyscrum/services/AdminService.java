package com.joyscrum.services;

import com.joyscrum.cache.FindValue;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Servicios variados de administración
 */
@Path("/admin")
public class AdminService {

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/cache/{cacheName}")
    public String clearCache(@PathParam("cacheName")String cacheName){
        FindValue.clearCache(cacheName);
        return "ok";
    }
}
