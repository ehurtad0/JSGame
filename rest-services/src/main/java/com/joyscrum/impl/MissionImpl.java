package com.joyscrum.impl;

import com.joyscrum.ConnectionDB;
import com.joyscrum.cache.FindValue;
import com.joyscrum.models.Mission;
import com.joyscrum.models.MissionPlayer;
import com.joyscrum.models.Player;
import com.joyscrum.models.Rol;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;

import javax.inject.Inject;
import javax.ws.rs.NotFoundException;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Jorge Mota
 * on 4/4/17.
 */
public class MissionImpl {
    @Inject
    ConnectionDB connection;

    public List<Mission> listMissionsByRol(ObjectId userId) {
        if (!ObjectId.isValid(userId.toHexString())) {
            throw new NotFoundException("Usuario o Rol no válido");
        }
        Datastore store = connection.getDataStore();
        Player player = FindValue.getSingle(store.createQuery(Player.class).field("id").equal(userId),userId.toHexString());

        if (player == null || player.getRolId() == null ||player.getRolId().length()<=9 ) {
            throw new NotFoundException("Usuario o Rol no válido");
        }
        //Rol rol = store.createQuery(Rol.class).filter("id", player.getRol().getId()).get();
      //  System.out.println(rol.getId().toHexString());
        List<Mission> missions = store.createQuery(Mission.class).filter("rolId", player.getRolId()).asList();

       // return store.createQuery(Mission.class).filter("rolId", player.getRolId()).asList();//.filter("id",userId).asList();
        return missions;
        //.asList();

    }

   /* public List<Mission> listMissionsForUser(ObjectId userId, ObjectId rolId) {
        if (!ObjectId.isValid(userId.toHexString())) {
            throw new NotFoundException("Usuario o Rol no válido");
        }
        Datastore store = connection.getDataStore();

        return store.createQuery(Mission.class).field().equals().asList();//.filter("id",userId).asList();
        //.asList();

    }*/

    public Player assignMission(ObjectId userId, ObjectId missionId) {
        Datastore store = connection.getDataStore();

        Player player = store.createQuery(Player.class).field("id").equal(userId).get();
        if (!ObjectId.isValid(userId.toHexString()) || player == null) {
            return null;
        }
        MissionPlayer missionPlayer = store.createQuery(MissionPlayer.class).field("mission._id").equal(missionId).get();
        if (!ObjectId.isValid(missionId.toHexString())) {
            return null;
        }
        if (missionPlayer == null) {
            Mission mission = store.createQuery(Mission.class).field("_id").equal(missionId).get();
            if (mission == null) {
                return null;
            }
            missionPlayer = new MissionPlayer();
            missionPlayer.setPlayerId(userId.toHexString());
            missionPlayer.setProgreso(0);
            missionPlayer.setAvance(0);
            missionPlayer.setCompleta(false);
            missionPlayer.setMissionId(mission.getId().toHexString());
            missionPlayer.setInicio(Calendar.getInstance().getTime());
            missionPlayer.setPuntos(0);
            missionPlayer.setRiesgo(0);
            store.save(missionPlayer);

        }

        // player.setMisionActual(mission);
        player.setMissionActualId(missionId.toHexString());
        store.save(player);
        PlayerImpl.setRelatedFields(store, player);

        return player;
    }
}
