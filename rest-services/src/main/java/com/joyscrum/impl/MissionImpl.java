package com.joyscrum.impl;

import com.joyscrum.ConnectionDB;
import com.joyscrum.models.Mission;
import com.joyscrum.models.Player;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;

import javax.inject.Inject;
import javax.ws.rs.NotFoundException;
import java.util.List;

/**
 * Created by jorge on 4/4/17.
 */
public class MissionImpl {
    @Inject
    ConnectionDB connection;

    public List<Mission> listMissions(ObjectId userId, ObjectId rolId) {
        if (!ObjectId.isValid(userId.toHexString()) ){
            throw new NotFoundException("Usuario o Rol no válido");
        }
        Datastore store = connection.getDataStore();

        return  store.createQuery(Mission.class).asList();//.filter("id",userId).asList();
                //.asList();

    }
}
