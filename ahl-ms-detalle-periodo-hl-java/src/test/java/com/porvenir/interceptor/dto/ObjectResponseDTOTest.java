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
class ObjectResponseDTOTest {

    @InjectMocks
    private ObjectResponseDTO objectResponseDTO;

    private LoggerDto loggerDto;

    @BeforeEach
    void setUp() {
        loggerDto = LoggerDto.builder().parametersOut("{\n    \"code\": \"71396144d8120759ee522a6c3a85cb5711bfe0028cc2336f407a34484d8ee97d\"\n}").codeResponse("201").build();
    }

    @Test
    void error() {

        ObjectResponseDTO dtoIfIn = objectResponseDTO.error(loggerDto, "test");
        Assertions.assertNotNull(dtoIfIn);

        loggerDto.setParametersOut("{\"code\": \"71396144d8120759ee522a6c3a85cb5711bfe0028cc2336f407a34484d8ee97d\"}");
        ObjectResponseDTO dtoIfOut = objectResponseDTO.error(loggerDto, "test");
        Assertions.assertNotNull(dtoIfOut);
    }
}
