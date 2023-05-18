package com.porvenir.domain.service;

import com.porvenir.config.ConfigVariable;
import com.porvenir.domain.service.impl.HealthServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class HealthServiceTest {

    @Mock
    private ConfigVariable configVariable;

    @InjectMocks
    private HealthServiceImpl healthService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void ping() {
        Assertions.assertNotNull(healthService.ping());
    }
}
