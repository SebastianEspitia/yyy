package com.porvenir.interceptor.bean;

public interface LogPersistence {
    String getClientIdApplication();

    Boolean isEnabled();

    String getEndpoint();
}
