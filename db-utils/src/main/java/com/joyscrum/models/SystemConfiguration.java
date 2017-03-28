package com.joyscrum.models;

/**
 * Created by Jorge Mota
 * on 3/27/17.
 */
public class SystemConfiguration {


    private String environment;
    private String googleClientId;
    private String redirectURI;

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setGoogleClientId(String googleClientId) {
        this.googleClientId = googleClientId;
    }

    public String getGoogleClientId() {
        return googleClientId;
    }

    public void setRedirectURI(String redirectURI) {
        this.redirectURI = redirectURI;
    }

    public String getRedirectURI() {
        return redirectURI;
    }
}
