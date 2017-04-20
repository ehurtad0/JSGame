package com.joyscrum.impl;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeTokenRequest;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken.Payload;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.joyscrum.ConnectionDB;
import com.joyscrum.GetSystemConfiguration;
import com.joyscrum.models.MissionPlayer;
import com.joyscrum.models.Player;
import com.joyscrum.models.Rol;
import com.joyscrum.models.Team;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.ForbiddenException;
import javax.ws.rs.NotAllowedException;
import java.io.FileReader;
import java.io.IOException;
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
        //HashMap<String,MissionPlayer> _mission= new HashMap<>(missions.size());
        //  HashMap<String, Team> _team = new HashMap<>(teams.size());

        //       for (Team t : teams) {
//            _team.put(t.getId().toHexString(), t);
        //      }
        //for(Mission m :  missions){
        //    _mission.put(m.getId().toHexString(),m);
        //}
        //for (Player p : players) {
        //         if (_team.containsKey(p.getEquipoId())) {
        //           p.setEquipo(_team.get(p.getEquipoId()));
        //      }

        setRelatedFields(store, players.toArray(new Player[]{}));
        //store.createQuery(MissionPlayer.class).field("jugador_id").equal(p.getId().toHexString()).asList();
        //}
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
            List<Team> teams = store.createQuery(Team.class).asList();
            _team = new HashMap<>(teams.size());
            for (Team t : teams) {
                _team.put(t.getId().toHexString(), t);
            }
        }
        if (_rol == null) {
            List<Rol> rols = store.createQuery(Rol.class).asList();
            _rol = new HashMap<>(rols.size());
            for (Rol r : rols) {
                _rol.put(r.getId().toHexString(), r);
            }
        }
        MissionPlayer misionPlayer = null;
        for (Player p : players) {
            if (_team.containsKey(p.getEquipoId())) {
                p.setEquipo(_team.get(p.getEquipoId()));
            }
            if (_rol.containsKey(p.getRolId())) {
                p.setRol(_rol.get(p.getRolId()));
            }
            misionPlayer = store.createQuery(MissionPlayer.class).field("playerId").equal(p.getId().toHexString())
                    .field("missionId").equal(p.getMissionActualId())
                    .get();
            if (misionPlayer != null) {
                p.setMisionActual(misionPlayer);
            }
        }
    }


    private Payload validateToken(String token, String origin) {
        Payload result = null;
        try {
            String defOrigin = origin == null ? GetSystemConfiguration.getValue().getRedirectURI() : origin;
            FileReader fileJson = new FileReader("/opt/data/joyscrum/client_secret_localhost.json");
            GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(
                    JacksonFactory.getDefaultInstance(), fileJson);
            GoogleTokenResponse tokenResponse = null;
            tokenResponse = new GoogleAuthorizationCodeTokenRequest(
                    new NetHttpTransport(),
                    JacksonFactory.getDefaultInstance(),
                    "https://www.googleapis.com/oauth2/v4/token",
                    clientSecrets.getDetails().getClientId(),
                    clientSecrets.getDetails().getClientSecret(),
                    token, defOrigin

            ).execute();

            GoogleIdToken idToken = tokenResponse.parseIdToken();
            result = idToken.getPayload();
            if (result == null) {
                System.out.println("Error: " + origin);
            }

            // if (!result.getAudience().equals(CLIENT_ID)) {
            //     throw new NotAuthorizedException("Acceso inválido "+ result.getAudience() );
            // }

        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.out.println("no access ioException");
            e.printStackTrace();
            result = null;

        } catch (Exception e) {
            result = null;
            e.printStackTrace();
            System.out.println("no access Exception");
        }
        return result;
    }

    public Player logonPlayer(String token, String origin) throws RuntimeException {
        Payload result = validateToken(token, origin);
        if (result == null) {
            throw new ForbiddenException("Acceso inválido ");
        }
        Datastore store = connection.getDataStore();
        Player player = store.createQuery(Player.class).field("profileId").equal(result.getSubject())
                .field("email").equal((String) result.get("email"))
                .field("origin").equal("google").get();
        if (player == null) {
            player = new Player();
            player.setEsActivo(true);
            player.setEmail((String) result.get("email"));
            player.setAvatar((String) result.get("picture"));
            player.setNombre((String) result.get("name"));
            player.setProfileId(result.getSubject());
            player.setOrigin("google");
            player.setPuntos(0);
            player.setProgreso(0.00);
            player.setRegistro(df.format(Calendar.getInstance().getTime()));
            store.save(player);

        }
        if (!player.isEsActivo()) {
            throw new NotAllowedException("Usuario no activo");
        }
        setRelatedFields(store, player);
        return player;
    }

    public boolean updateTeam(ObjectId userId, ObjectId teamId) {
        Datastore store = connection.getDataStore();
        Player player = getPlayer(userId, store);//store.createQuery(Player.class).field("id").equal(userId).get();
        if (player == null) {
            return false;
        }
        Team team = store.createQuery(Team.class).field("_id").equal(teamId).get();
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
        Rol rol = store.createQuery(Rol.class).field("_id").equal(rolId).get();
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
        store.save(storedPlayer);
        return true;
    }

    public MissionPlayer getCurrentMission(String userId) {
        Datastore store = connection.getDataStore();
        Player player = getPlayer(userId, store);
        return getCurrentMission(player, store);
    }

    private MissionPlayer getCurrentMission(Player player, Datastore store) {
        MissionPlayer missionPlayer = store.createQuery(MissionPlayer.class).field("playerId").equal(player.getId().toHexString())
                .field("missionId").equal(player.getMissionActualId())
                .get();
        return missionPlayer;
    }

    public static Player getPlayer(ObjectId userId, Datastore store) {
        return store.createQuery(Player.class).field("id").equal(userId).get();

    }

    public static Player getPlayer(String userId, Datastore store) {
        return getPlayer(new ObjectId(userId), store);
    }
}
