package com.joyscrum.models;

/**
 * Created by Jorge Mota
 * on 3/27/17.
 */
public class SystemConfiguration {


    private String environment;
    private String googleClientId;
    private String trelloClientId;
    private String redirectURI;

    private boolean allowPlainRequest;
    private boolean CORSAllowed;

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

    public String getTrelloClientId() {
        return trelloClientId;
    }

    public void setTrelloClientId(String trelloClientId) {
        this.trelloClientId = trelloClientId;
    }

    public void setRedirectURI(String redirectURI) {
        this.redirectURI = redirectURI;
    }

    public String getRedirectURI() {
        return redirectURI;
    }

    public void setAllowPlainRequest(boolean allowPlainRequest) {
        this.allowPlainRequest = allowPlainRequest;
    }

    public boolean isAllowPlainRequest() {
        return allowPlainRequest;
    }

    public boolean isCORSAllowed() {
        return CORSAllowed;
    }

    public void setCORSAllowed(boolean CORSAllowed) {
        this.CORSAllowed = CORSAllowed;
    }
}
