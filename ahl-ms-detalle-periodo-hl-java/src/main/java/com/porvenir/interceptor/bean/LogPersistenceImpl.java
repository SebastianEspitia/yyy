package com.porvenir.interceptor.bean;

public class LogPersistenceImpl implements LogPersistence {
    //
    private String clientIdApplication;
    private String enabled;
    private String endpoint;
    //
    public LogPersistenceImpl(String clientIdApplication, String enabled, String endpoint) {
        this.clientIdApplication = clientIdApplication;
        this.enabled = enabled;
        this.endpoint = endpoint;
    }
    //


    @Override
    public String getClientIdApplication() {
        return clientIdApplication;
    }

    @Override
    public Boolean isEnabled() {
        return "true".equals(this.enabled);
    }

    @Override
    public String getEndpoint() {
        return endpoint;
    }
}
