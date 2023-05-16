package com.porvenir.interceptor.service;

import com.porvenir.interceptor.bean.LogPersistence;
import com.porvenir.interceptor.integration.TraceIntegration;
import com.porvenir.interceptor.integration.dto.TraceDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TraceServiceTest {

    @InjectMocks
    private TraceService traceService;

    @Mock
    private TraceIntegration traceIntegration;
    @Mock
    private LogPersistence logPersistence;

    private static final Logger LOG = LoggerFactory.getLogger(TraceService.class);

    @BeforeEach
    void setUp() {

    }

    @Test
    void registerTrace() {

        TraceDto traceDto = TraceDto.builder().traceId("1").channel("1").idClientAplication("1").typeIdPerson("1").idPerson("1").nameComponent("1").urlServices("1").ipRequest("1").idServices("1").parametersIn("1").parametersOut("1").codeResponse("1").messageResponse("1").detailTrace("1").timeConsumeService(1L).timeResponseService(1L).build();

        when(logPersistence.getClientIdApplication()).thenReturn("test");
        when(logPersistence.isEnabled()).thenReturn(false);
        traceService.registerTrace(traceDto);
        Assertions.assertNotNull(traceDto);

        ResponseEntity entity = new ResponseEntity(HttpStatus.OK);
        when(logPersistence.isEnabled()).thenReturn(true);
        when(traceIntegration.save(traceDto)).thenReturn(entity);
        traceService.registerTrace(traceDto);
        verify(traceIntegration).save(traceDto);

        when(logPersistence.isEnabled()).thenReturn(true);
        when(traceIntegration.save(traceDto)).thenReturn(null);
        traceService.registerTrace(traceDto);
        Assertions.assertNotNull(traceDto);
    }

    @Test
    void logTrace() {

        traceService.logTrace(null);
    }
}
