package com.joyscrum.auth;

import com.joyscrum.ConnectionDB;
import com.joyscrum.GetSystemConfiguration;
import com.joyscrum.impl.PlayerImpl;
import com.joyscrum.models.Player;
import com.julienvey.trello.Trello;
import com.julienvey.trello.TrelloHttpClient;
import com.julienvey.trello.domain.Member;
import com.julienvey.trello.impl.TrelloImpl;
import com.julienvey.trello.impl.http.ApacheHttpClient;
import org.mongodb.morphia.Datastore;

import javax.inject.Inject;
import javax.ws.rs.NotAllowedException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Clase para autorización de Trello
 */
public class TrelloAuth implements IAuthProvider {
    @Inject
    ConnectionDB connection;
    static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public Player logonPlayer(String origin, String token) {

      return validateToken(token);
    }

    private Player validateToken(String token) {

        Trello trello = new TrelloImpl(GetSystemConfiguration.getValue().getTrelloClientId(), token,new ApacheHttpClient());
        Member profile = trello.getMemberInformation("me");
        Datastore store = connection.getDataStore();
        Player player = store.createQuery(Player.class).field("profileId").equal(profile.getId())
               // .field("email").equal(profile.getEmail())
                .field("origin").equal("trello").get();
        if (player == null) {
            player = new Player();
            player.setNuevoUsuario(true);
            player.setEsActivo(true);
            player.setEmail(profile.getEmail());
            player.setAvatar("");
            player.setNombre(profile.getFullName());
            player.setProfileId(profile.getId());
            player.setOrigin("trello");
            player.setPuntos(0);
            player.setProgreso(0.00);
            player.setRegistro(df.format(Calendar.getInstance().getTime()));
            store.save(player);
        }
        if (!player.isEsActivo()) {
            throw new NotAllowedException("Usuario no activo");
        }
        PlayerImpl.setRelatedFields(store, player);
        return player;
    }
}
