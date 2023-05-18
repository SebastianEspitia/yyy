package com.porvenir.interceptor.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ConfigPropertiesInterceptorTest {

    @InjectMocks
    private ConfigPropertiesInterceptor configPropertiesInterceptor;

    @BeforeEach
    void setUp() {
    }

    @Test
    void logPersistence() {
        Assertions.assertNotNull(configPropertiesInterceptor.logPersistence());
    }
}
