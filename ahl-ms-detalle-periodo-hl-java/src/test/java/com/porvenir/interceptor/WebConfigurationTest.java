package com.porvenir.interceptor;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class WebConfigurationTest {

    @InjectMocks
    private WebConfiguration webConfiguration;

    @Mock
    private GeneralInterceptor generalInterceptor;
    @Mock
    private InterceptorRegistry registry;

    @Test
    void addInterceptors() {
        webConfiguration.addInterceptors(registry);
    }
}
