package com.porvenir.interceptor.util;

import com.porvenir.interceptor.bean.LogPersistence;
import com.porvenir.interceptor.bean.LogPersistenceImpl;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@NoArgsConstructor
@Getter
@Configuration
public class ConfigPropertiesInterceptor{

    @Value("${param.trace.logs.clientapp}")
    private String logClientApp;

    @Value("${param.trace.logs.persistence}")
    private String logPersistenceEnabled;

    @Value("${param.trace.logs.endpointws.savelogs}")
    private String endPointWsSavelogs;

    @Bean
    public LogPersistence logPersistence() {
        return new LogPersistenceImpl(logClientApp, logPersistenceEnabled, endPointWsSavelogs);
    }

}