package com.joyscrum;

import com.joyscrum.models.SystemConfiguration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Jorge Mota
 * on 3/27/17.
 */

public class GetSystemConfiguration {
    static SystemConfiguration conf = null;

    static {
        try {
            FileInputStream file = new FileInputStream("/opt/data/joyscrum/settings.properties");
            Properties props = new Properties();
            props.load(file);
            conf = new SystemConfiguration();
            conf.setEnvironment(props.getProperty("environment", "localhost"));
            conf.setGoogleClientId(props.getProperty("googleClientId", "773332083832-eh42icaooprq2ojlr5jeupf8lkskoaub.apps.googleusercontent.com"));
            conf.setRedirectURI(props.getProperty("redirectURI", "http://localhost:8080"));

            boolean allow=false;
            String tmp =(String)props.get("plainRequest");
            if (tmp==null){

            }else{
                allow =tmp.equals("yes");
            }
            conf.setAllowPlainRequest(allow);
            allow=false;
             tmp =(String)props.get("allowCORS");
            if (tmp==null){

            }else{
                allow =tmp.equals("yes");
            }
            conf.setCORSAllowed(allow);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String... args) {
        boolean x = conf.isAllowPlainRequest();
        System.out.println(conf.isAllowPlainRequest());
    }

    public SystemConfiguration get() {
        return conf;
    }

    public static SystemConfiguration getValue() {
        return conf;
    }



}
