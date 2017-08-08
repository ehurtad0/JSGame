package com.joyscrum.impl;

import com.joyscrum.ConnectionDB;
import com.joyscrum.cache.FindValue;
import com.joyscrum.models.Mission;
import com.joyscrum.models.MissionPlayer;
import com.joyscrum.models.Player;
import com.joyscrum.models.SubMission;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;

import javax.inject.Inject;
import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
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
        Player player = FindValue.getSingle(store.createQuery(Player.class).field("id").equal(userId), userId.toHexString(), true);
        if (player == null || player.getRolId() == null || player.getRolId().length() <= 9) {
            throw new NotFoundException("Usuario o Rol no válido");
        }
        List<Mission> missions = FindValue.getList(store.createQuery(Mission.class).filter("rolId", player.getRolId()), player.getRolId());
        return missions;
    }

    public List<MissionPlayer> listMissionPointsByPlayer(ObjectId userId) {
        Datastore store = connection.getDataStore();
        //Player player = store.createQuery(Player.class).field("id").equal(userId).get();

        List<MissionPlayer> missions = store.createQuery(MissionPlayer.class).field("playerId").equal(userId.toHexString()).asList();
        return missions;
    }

   /* public List<Mission> listMissionsForUser(ObjectId userId, ObjectId rolId) {
        if (!ObjectId.isValid(userId.toHexString())) {
            throw new NotFoundException("Usuario o Rol no válido");
        }
        Datastore store = connection.getDataStore();

        return store.createQuery(Mission.class).field().equals().asList();//.filter("id",userId).asList();
        //.asList();

    }*/

    public Player assignMission(ObjectId userId, String missionId) {
        Datastore store = connection.getDataStore();
        Player player = store.createQuery(Player.class).field("id").equal(userId).get();
        if (!ObjectId.isValid(userId.toHexString()) || player == null) {
            return null;
        }
        String[] missionList = missionId.split(",");
        MissionPlayer[] listado = new MissionPlayer[missionList.length + 1];

        for (int i = 0; i < listado.length; i++) {
            listado[i] = null;
        }
        int i = 0;
        String keyMadre = missionList[0];
        String keyHija, keyNieta;
        //Mission mission = FindValue.getSingle(store.createQuery(Mission.class).field("id").equal(new ObjectId(keyMadre)),keyMadre);

        int level = missionList.length;


        MissionPlayer missionMadre = store.createQuery(MissionPlayer.class).field("missionId").equal(keyMadre).field("playerId").equal(userId.toHexString()).get();
        if (missionMadre == null) {
            missionMadre = new MissionPlayer();
            missionMadre.setPlayerId(userId.toHexString());
            missionMadre.setProgreso(0);
            missionMadre.setCompleta(false);
            missionMadre.setMissionId(keyMadre);
            missionMadre.setInicio(Calendar.getInstance().getTime());
            missionMadre.setPuntos(0);
            missionMadre.setRolId((player.getRolId()));
            listado[i] = missionMadre;
            i++;
        }
        if (level >= 2) {
            keyHija = missionList[1];
            MissionPlayer missionHija = store.createQuery(MissionPlayer.class).field("missionId").equal(keyHija).field("playerId").equal(userId.toHexString()).get();
            if (missionHija == null) {
                missionHija = new MissionPlayer();
                missionHija.setPlayerId(userId.toHexString());
                missionHija.setCompleta(false);
                missionHija.setProgreso(0);
                missionHija.setMissionId(keyHija);
                missionHija.setInicio(Calendar.getInstance().getTime());
                missionHija.setPuntos(0);
                missionHija.setRolId((player.getRolId()));
                listado[i] = missionHija;
                i++;
            }
        }
        if (level >= 3) {
            keyNieta = missionList[2];
            MissionPlayer missionNieta = store.createQuery(MissionPlayer.class).field("missionId").equal(keyNieta).field("playerId").equal(userId.toHexString()).get();
            if (missionNieta == null) {
                missionNieta = new MissionPlayer();
                missionNieta.setPlayerId(userId.toHexString());
                missionNieta.setCompleta(false);
                missionNieta.setProgreso(0);
                missionNieta.setRolId((player.getRolId()));
                missionNieta.setMissionId(keyNieta);
                missionNieta.setInicio(Calendar.getInstance().getTime());
                missionNieta.setPuntos(0);
                listado[i] = missionNieta;
                i++;
            }
        }

        player.setMissionActualId(missionId);
        store.save(player);

        for (int r = 0; r < listado.length; r++) {
            MissionPlayer addMission = listado[r];
            if (addMission != null) {
                store.save(addMission);
            }
        }
        PlayerImpl.setRelatedFields(store, player);

        return player;
    }

    public MissionPlayer incrementProgressMission(ObjectId userId, double increment) {

        Datastore store = connection.getDataStore();
        Player player = store.createQuery(Player.class).field("id").equal(userId).get();
        if (!ObjectId.isValid(userId.toHexString()) || player == null) {
            return null;
        }
        String[] missionList = player.getMissionActualId().split(",");
        MissionPlayer[] listado = new MissionPlayer[missionList.length];
        for (int i = 0; i < missionList.length; i++) {
            listado[i] = store.createQuery(MissionPlayer.class).field("missionId").equal(missionList[i]).field("playerId").equal(userId.toHexString()).get();
        }

        int level = missionList.length;
        // int i = 0;
        Mission misionMadre = null;
        SubMission misionHija = null, misionNieta = null;
        misionMadre = FindValue.getSingle(
                store.createQuery(Mission.class).field("id").equal(new ObjectId(missionList[0])), missionList[0]);
        if (level >= 2) {
            for (SubMission sub : misionMadre.getDetalleMision()) {

                if (sub.getMissionId().toHexString().equals(missionList[1])) {
                    misionHija = sub;
                    break;
                }
            }
        }
        if (level >= 3) {
            for (SubMission sub : misionHija.getDetalleMision()) {

                if (sub.getMissionId().toHexString().equals(missionList[1])) {
                    misionNieta = sub;
                    break;
                }
            }
        }

        MissionPlayer madre, hija, nieta, result = null;
        if (level == 3) {
            //misionNieta = FindValue.getSingle(
            //        store.createQuery(Mission.class).field("missionId").equal(missionList[2]), missionList[2]
            //);
            // misionHija = FindValue.getSingle(
            //         store.createQuery(Mission.class).field("missionId").equal(missionList[1]), missionList[1]
            // );
            madre = listado[0];
            hija = listado[1];
            nieta = listado[2];
            double porcNietaActual = nieta.getProgreso() * misionNieta.getValorMision() / 100;

            double porcHijaActual = hija.getProgreso() * misionHija.getValorMision() / 100;

            nieta.sumarProgreso(increment);

            double porcNietaNuevo = nieta.getProgreso() * misionNieta.getValorMision() / 100;

            hija.sumarProgreso(porcNietaNuevo - porcNietaActual);

            double porcHijaNuevo = hija.getProgreso() * misionHija.getValorMision() / 100;
            madre.sumarProgreso(porcHijaNuevo - porcHijaActual);

            if (nieta.isCompleta()) {
                nieta.setPuntos(misionNieta.getPuntosMision());
                player.sumarPuntos(nieta.getPuntos());
            }
            if (hija.isCompleta()) {
                hija.setPuntos(misionHija.getPuntosMision());
                player.sumarPuntos(hija.getPuntos());
            }
            if (madre.isCompleta()) {
                madre.setPuntos(misionMadre.getPuntosMision());
                player.sumarPuntos(madre.getPuntos());
            }
            store.save(nieta);
            store.save(hija);
            store.save(madre);
            result = nieta;

        }
        if (level == 2) {

            //misionHija = FindValue.getSingle(
            //        store.createQuery(Mission.class).field("missionId").equal(missionList[1]), missionList[1]
            //);
            madre = listado[0];
            hija = listado[1];
            double porcHijaActual = hija.getProgreso() * misionHija.getValorMision() / 100;

            //double porcMadreActual = madre.getProgreso() * misionMadre.getValor() / 100;

            hija.sumarProgreso(increment);


            double porcHijaNuevo = hija.getProgreso() * misionHija.getValorMision() / 100;
            madre.sumarProgreso(porcHijaNuevo - porcHijaActual);

            if (hija.isCompleta()) {
                hija.setPuntos(misionHija.getPuntosMision());
                player.sumarPuntos(hija.getPuntos());
            }
            if (madre.isCompleta()) {
                madre.setPuntos(misionMadre.getPuntosMision());
                player.sumarPuntos(madre.getPuntos());
            }
            store.save(hija);
            store.save(madre);
            result = hija;
        }
        if (level == 1) {
            madre = listado[0];
            madre.sumarProgreso(increment);
            if (madre.isCompleta()) {
                madre.setPuntos(misionMadre.getPuntosMision());
                player.sumarPuntos(madre.getPuntos());
            }
            store.save(madre);
            result = madre;
        }
        store.save(player);
        return result;
    }

    public List<MissionPlayer> getProgressMission(ObjectId userId) {
        Datastore store = connection.getDataStore();
        Player player = store.createQuery(Player.class).field("id").equal(userId).get();
        if (!ObjectId.isValid(userId.toHexString()) || player == null) {
            return null;
        }
        String[] missionList = player.getMissionActualId().split(",");
        List<MissionPlayer> list = new ArrayList<>(missionList.length);
        for (int i = 0; i < missionList.length; i++) {
            list.add(store.createQuery(MissionPlayer.class).field("missionId").equal(missionList[i]).field("playerId").equal(userId.toHexString()).get());
        }
        return list;
    }
}
