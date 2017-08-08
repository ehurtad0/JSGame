package com.joyscrum.impl;

import com.joyscrum.ConnectionDB;
import com.joyscrum.GetSystemConfiguration;
import com.joyscrum.cache.FindValue;
import com.joyscrum.models.MissionPlayer;
import com.joyscrum.models.Player;
import com.joyscrum.models.Rol;
import com.joyscrum.models.Team;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Criteria;
import org.mongodb.morphia.query.Query;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;


/**
 * Created by Jorge Mota
 * on 3/24/17.
 */
@Stateless
public class PlayerImpl {
    @Inject
    ConnectionDB connection;
    static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    final static String CLIENT_ID = GetSystemConfiguration.getValue().getGoogleClientId();

    public List<Player> listPlayers() {
        Datastore store = connection.getDataStore();

        List<Player> players = store.createQuery(Player.class).asList();
        List<MissionPlayer> missions = null;
        List<Team> teams = store.createQuery(Team.class).asList();
        setRelatedFields(store, players.toArray(new Player[]{}));
        return players;
    }

    private static HashMap<String, Team> _team = null;
    private static HashMap<String, Rol> _rol = null;

    public static void clearItems(boolean clearTeam, boolean clearRol) {
        if (clearTeam) {
            _team = null;
        }
        if (clearRol) {
            _rol = null;
        }
    }

    public static void setRelatedFields(Datastore store, Player... players) {
        if (_team == null) {
            List<Team> teams = FindValue.getList(store.createQuery(Team.class), "teamsList");
            _team = new HashMap<>(teams.size());
            for (Team t : teams) {
                _team.put(t.getId().toHexString(), t);
            }
        }
        if (_rol == null) {
            List<Rol> rols = FindValue.getList(store.createQuery(Rol.class), "rolesList");
            _rol = new HashMap<>(rols.size());
            for (Rol r : rols) {
                _rol.put(r.getId().toHexString(), r);
            }
        }
        MissionPlayer misionPlayer = null;
        String[] missionList;
        for (Player p : players) {
            if (_team.containsKey(p.getEquipoId())) {
                p.setEquipo(_team.get(p.getEquipoId()));
            }
            if (_rol.containsKey(p.getRolId())) {
                p.setRol(_rol.get(p.getRolId()));
            }
           /* misionPlayer = store.createQuery(MissionPlayer.class).field("playerId").equal(p.getId().toHexString())
                    .field("missionId").equal(p.getMissionActualId())
                    .get();
            if (misionPlayer != null) {
                p.setMisionActual(misionPlayer);
            }*/
            if (p.getMissionActualId() != null) {
                missionList = p.getMissionActualId().split(",");
                misionPlayer = store.createQuery(MissionPlayer.class).field("missionId").equal(missionList[0]).field("playerId").equal(p.getPk()).get();
                if (misionPlayer != null) {
                    misionPlayer.setRiesgoMision(100 - misionPlayer.getProgreso());
                    p.setMisionActual(misionPlayer);
                }
            }
        }

    }

    public boolean updateTeam(ObjectId userId, ObjectId teamId) {
        Datastore store = connection.getDataStore();
        Player player = getPlayer(userId, store);//store.createQuery(Player.class).field("id").equal(userId).get();
        if (player == null) {
            return false;
        }
        Team team = FindValue.getSingle(store.createQuery(Team.class).field("_id").equal(teamId), teamId.toHexString());
        if (team == null) {
            return false;
        }
        player.setEquipoId(teamId.toHexString());
        store.save(player);
        return true;
    }

    public boolean updateRol(ObjectId userId, ObjectId rolId) {
        Datastore store = connection.getDataStore();

        Player player = getPlayer(userId, store);// store.createQuery(Player.class).field("id").equal(userId).get();
        if (!ObjectId.isValid(rolId.toHexString()) || player == null) {
            return false;
        }
        Rol rol = FindValue.getSingle(store.createQuery(Rol.class).field("_id").equal(rolId), rolId.toHexString());

        //.get();
        if (!ObjectId.isValid(userId.toHexString()) || rol == null) {
            return false;
        }

        player.setRolId(rolId.toHexString());
        store.save(player);

        return true;
    }

    public boolean updatePlayer(ObjectId userId, Player player) {
        Datastore store = connection.getDataStore();

        // Player storedPlayer = store.createQuery(Player.class).field("id").equal(userId).get();
        Player storedPlayer = getPlayer(userId, store);
        if (!ObjectId.isValid(userId.toHexString()) || player == null) {
            return false;
        }

        storedPlayer.setEsActivo(player.isEsActivo());
        //if (player.getProgreso()>0) {
        //    storedPlayer.setProgreso(player.getProgreso());
        // }
        if (player.getDireccion() != null) {
            storedPlayer.setDireccion(player.getDireccion());
        }
        if (player.getEdad() > 0) {
            storedPlayer.setEdad(player.getEdad());
        }
        if (player.getFechaNac() != null && player.getFechaNac().length() > 0) {
            storedPlayer.setFechaNac(player.getFechaNac());
        }
        if (player.getGenero() != null && player.getGenero().length() > 0) {
            storedPlayer.setGenero(player.getGenero());
        }
        if (player.getNombre() != null && player.getNombre().length() > 0) {
            storedPlayer.setNombre(player.getNombre());
        }
        if (player.getAvatar() != null && player.getAvatar().length() > 0) {
            storedPlayer.setAvatar(player.getAvatar());
        }
        store.save(storedPlayer);
        return true;
    }

    public List<MissionPlayer> getCurrentMission(String userId) {
        Datastore store = connection.getDataStore();
        Player player = getPlayer(userId, store);
        return getCurrentMission(player, store);
    }

    private List<MissionPlayer> getCurrentMission(Player player, Datastore store) {
        String[] listMission =player.getMissionActualId().split(",");
        Query<MissionPlayer> query = store.createQuery(MissionPlayer.class);
        query.and(query.criteria("playerId").equal(player.getPk()));
        Criteria[] listCriteria= new Criteria[listMission.length];
          for (int i=0; i<listMission.length;i++){
              listCriteria[i] = query.criteria("missionId").equal(listMission[i]);
          }
          query.and(query.or(listCriteria));
          return query.asList();
      /*  MissionPlayer missionPlayer =
                FindValue.getSingle(
                        .field("playerId").equal(player.getId().toHexString())
                        .field("missionId").equal(player.getMissionActualId()), player.getMissionActualId(), true);*/
//        return missionPlayer;
    }

    public static Player getPlayer(ObjectId userId, Datastore store) {
        //return store.createQuery(Player.class).field("id").equal(userId).get();
        return FindValue.getSingle(store.createQuery(Player.class).field("id").equal(userId), userId.toHexString(), true);

    }

    public static Player getPlayer(String userId, Datastore store) {
        return getPlayer(new ObjectId(userId), store);
    }

    public MissionPlayer updateCurrentMission(String userId, String missionId) {
        Datastore store = connection.getDataStore();
        Player player = getPlayer(userId, store);
        MissionPlayer missionPlayer = FindValue.getSingle(store.createQuery(MissionPlayer.class).field("playerId").equal(player.getPk())
                .field("missionId").equal(missionId), userId + missionId, true);
        if (missionPlayer == null) {
            missionPlayer = new MissionPlayer();
            missionPlayer.setPuntos(0);
            missionPlayer.setInicio(Calendar.getInstance().getTime());
            missionPlayer.setCompleta(false);
            missionPlayer.setMissionId(missionId);
            missionPlayer.setProgreso(0);
            missionPlayer.setPlayerId(userId);
            store.save(missionPlayer);
        }
        player.setMissionActualId(missionId);
        store.save(player);
        return missionPlayer;
    }

    public Player getProfile(String userId) {
        Datastore store = connection.getDataStore();
        Player player = getPlayer(userId, store);
        setRelatedFields(store, player);
        return player;
    }
}
