package com.joyscrum;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import javax.enterprise.inject.Model;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jorge Mota on
 * 3/15/17.
 */
@Model
public class ConnectionDB {
    public Datastore getDataStore() {
        return getDataStore(null);
    }

    public Datastore getDataStore(String packages) {
        final Morphia morphia = new Morphia();
        morphia.mapPackage("com.joyscrum.models");
        if (packages!=null) {
            morphia.mapPackage(packages);
        }
        ServerAddress addr = new ServerAddress("159.203.65.97", 4321);
        List<MongoCredential> credentialsList = new ArrayList<>();
        MongoCredential credentia = MongoCredential.createCredential(
                "jmota", "joyscrum", "alternative".toCharArray());
        credentialsList.add(credentia);
        MongoClient client = new MongoClient(addr, credentialsList);
        final Datastore datastore = morphia.createDatastore(client, "joyscrum");
        datastore.ensureIndexes();
        return datastore;
    }
}
