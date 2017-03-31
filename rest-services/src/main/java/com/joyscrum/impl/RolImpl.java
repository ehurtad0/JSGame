package com.joyscrum.impl;

import com.joyscrum.ConnectionDB;
import com.joyscrum.models.Rol;
import org.mongodb.morphia.Datastore;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by Jorge Mota
 * on 3/28/17.
 */
@Stateless
public class RolImpl {
    @Inject
    ConnectionDB connection;

    public List<Rol> getList() {
        Datastore store = connection.getDataStore();
        return store.createQuery(Rol.class).asList();
    }
}
