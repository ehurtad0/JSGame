package com.joyscrum;

import com.joyscrum.models.SystemConfiguration;

import javax.enterprise.inject.Model;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Jorge Mota
 * on 3/27/17.
 */

public class GetSystemConfiguration {
    static SystemConfiguration conf=null;

    static {
        try {
            FileInputStream file = new FileInputStream("/opt/data/joyscrum/settings.properties");
            Properties props = new Properties();
            props.load(file);
            conf = new SystemConfiguration();
            conf.setEnvironment(props.getProperty("environment", "localhost"));
            conf.setGoogleClientId(props.getProperty("googleClientId", "773332083832-eh42icaooprq2ojlr5jeupf8lkskoaub.apps.googleusercontent.com"));
            conf.setRedirectURI(props.getProperty("redirectURI", "http://localhost:8080"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public SystemConfiguration get() {
        return conf;
    }

    public static SystemConfiguration getValue() {
        return conf;
    }

}
