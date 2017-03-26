package com.joyscrum.impl;

import com.joyscrum.ConnectionDB;
import com.joyscrum.models.Player;
import org.mongodb.morphia.Datastore;

import javax.ejb.Singleton;
import javax.inject.Inject;
import java.util.List;

/**
 * Created by Jorge Mota
 * on 3/24/17.
 */
@Singleton

public class PlayerImpl {
    @Inject
    ConnectionDB connection;

    public List<Player> listPlayers() {
        Datastore store = connection.getDataStore();
        return store.createQuery(Player.class).asList();
    }
}
