package com.porvenir.interceptor.integration.mapper;

import com.porvenir.interceptor.dto.LoggerDto;
import com.porvenir.interceptor.integration.dto.TraceDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TraceMapperTest {

    @InjectMocks
    private TraceMapperImpl traceMapperImpl;

    private LoggerDto loggerDto;

    @BeforeEach
    void setUp() {
        loggerDto = LoggerDto.builder().traceId("1").channel("1").idClientAplication("1").typeIdPerson("1").idPerson("1").nameComponent("1").urlServices("1").ip("1").idServices("1").parametersIn("1").parametersOut("1").codeResponse("1").messageResponse("1").detailTrace("1").build();
    }

    @Test
    void toTrace() {

        TraceDto traceDto;
        traceDto = traceMapperImpl.toTrace(loggerDto);
        Assertions.assertNotNull(traceDto);

        loggerDto = LoggerDto.builder().build();
        traceDto = traceMapperImpl.toTrace(loggerDto);
        Assertions.assertNotNull(traceDto);
    }
}
