package com.joyscrum.cache;

import com.hazelcast.config.Config;
import com.hazelcast.config.ManagementCenterConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

import javax.inject.Singleton;
import javax.ws.rs.ext.Provider;

/**
 * CacheProvider using HazelCast
 */
@Provider
@Singleton
public class CacheProvider {
    private static HazelcastInstance hz = null;

    public static HazelcastInstance getCacheInstance() {
        if (hz == null) {
            System.setProperty("hazelcast.mc.rest.enabled","true");
            Config config = new Config();
            config.setInstanceName("JoyScrumApi");
            config.getGroupConfig().setName("joyscrum");
            config.getGroupConfig().setPassword("JoyScrum2017");
            //ManagementCenterConfig manCenterCfg = new ManagementCenterConfig();
           // manCenterCfg.setEnabled(true).setUrl("http://localhost:8090/mancenter");
            //config.setManagementCenterConfig(manCenterCfg);
            hz = Hazelcast.getOrCreateHazelcastInstance(config);
        }
        return hz;
    }

    public void finalize() throws Throwable {
        try {
            hz.shutdown();
            hz=null;
        } catch (Exception e) {

        }
    }
}
