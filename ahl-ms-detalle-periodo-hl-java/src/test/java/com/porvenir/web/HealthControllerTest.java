package com.porvenir.web;

import com.porvenir.domain.dto.ResponseStatusServiceDto;
import com.porvenir.domain.service.HealthService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class HealthControllerTest {

    @InjectMocks
    private HealthController healthController;

    @Mock
    private HealthService healthService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void ping() {

        when(healthService.ping()).thenReturn(ResponseStatusServiceDto.builder().appName("soa-ms-authorizer-java").build());

        ResponseEntity<ResponseStatusServiceDto> test = healthController.ping();

        Assertions.assertNotNull(test);
    }
}
