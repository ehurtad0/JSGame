package com.joyscrum.services;

import com.joyscrum.impl.RolImpl;
import com.joyscrum.models.Rol;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Jorge Mota
 * on 3/20/17.
 */
@Path("rol")
public class RolService {
    @Inject
    RolImpl service;
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Rol> list(){
        return service.getList();
    }
}
