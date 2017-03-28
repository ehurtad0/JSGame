package com.joyscrum.impl;

import com.joyscrum.ConnectionDB;
import com.joyscrum.models.Team;
import org.mongodb.morphia.Datastore;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by Jorge Mota
 * on 3/27/17.
 */
@Stateless

public class TeamImpl {
    @Inject
    ConnectionDB connection;
    static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public List<Team> list() {
        Datastore store = connection.getDataStore();
        return store.createQuery(Team.class).asList();
    }

    public Team update(Team team,String id) {
        Datastore store = connection.getDataStore();
        Team result = null;
        if (!id.equals("-1")) {
            Team onStore = store.createQuery(Team.class).field("id").equal(id).get();
            if (onStore != null) {
                result = onStore;
                result.setGuid(team.getGuid());
                result.setIndex(team.getIndex());
                result.setLogoEquipo(team.getLogoEquipo());
                result.setNombreEquipo(team.getNombreEquipo());
                result.setProgresoEquipo(team.getProgresoEquipo());
                result.setPuntos(team.getPuntos());
            }
        }
        if (result == null) {
            result = team;
            result.setId(null);
        }
        store.save(result);
        return result;

    }
}
