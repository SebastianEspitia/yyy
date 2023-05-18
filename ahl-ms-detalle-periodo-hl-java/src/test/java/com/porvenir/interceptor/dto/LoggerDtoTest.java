package com.porvenir.interceptor.dto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LoggerDtoTest {

    @InjectMocks
    private LoggerDto loggerDto;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getInstance() {

        LoggerDto logNull = LoggerDto.getInstance();
        Assertions.assertNotNull(logNull);

        LoggerDto logNotNull = LoggerDto.getInstance();
        Assertions.assertNotNull(logNotNull);
    }
}
