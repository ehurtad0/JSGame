package com.joyscrum.auth;

import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeTokenRequest;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.joyscrum.ConnectionDB;
import com.joyscrum.GetSystemConfiguration;
import com.joyscrum.impl.PlayerImpl;
import com.joyscrum.models.Player;
import org.mongodb.morphia.Datastore;

import javax.inject.Inject;
import javax.ws.rs.ForbiddenException;
import javax.ws.rs.NotAllowedException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Clase de autenticación para Google
 */
public class GoogleAuth implements IAuthProvider {
    @Inject
    ConnectionDB connection;
    static SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public Player logonPlayer(String origin, String token) {
        return getPlayer(origin, token);
    }

    private GoogleIdToken.Payload validateToken(String token, String origin) {
        GoogleIdToken.Payload result;
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

    private Player getPlayer(String origin, String token) throws RuntimeException {
        GoogleIdToken.Payload result = validateToken(token, origin);
        if (result == null) {
            throw new ForbiddenException("Acceso inválido ");
        }
        Datastore store = connection.getDataStore();
        Player player = store.createQuery(Player.class).field("profileId").equal(result.getSubject())
                .field("email").equal((String) result.get("email"))
                .field("origin").equal("google").get();
        if (player == null) {
            player = new Player();
            player.setNuevoUsuario(true);
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
        PlayerImpl.setRelatedFields(store, player);
        return player;
    }
}
