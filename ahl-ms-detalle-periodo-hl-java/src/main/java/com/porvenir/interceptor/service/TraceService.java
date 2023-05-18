package com.porvenir.interceptor.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.porvenir.interceptor.bean.LogPersistence;
import com.porvenir.interceptor.integration.TraceIntegration;
import com.porvenir.interceptor.integration.dto.TraceDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TraceService {
/*
   @Autowired
    private TraceIntegration traceIntegration;

    @Autowired
    private LogPersistence logPersistence;

    private static final Logger LOG = LoggerFactory.getLogger(TraceService.class);

    public void registerTrace(TraceDto traceDto) {
      /*  traceDto.setIdClientAplication(logPersistence.getClientIdApplication());
        //
        if (Boolean.TRUE.equals(logPersistence.isEnabled())) {
            ResponseEntity result = traceIntegration.save(traceDto);
            if(result != null) {
                logTrace(traceDto);
            }
        } else {
            logTrace(traceDto);
        }*/
    //}

   /* public void logTrace(TraceDto traceDto) {
        /*try {
            ObjectMapper mapper = new ObjectMapper();
            LOG.info("LOG: " + traceDto.getNameComponent() + ": " + mapper.writeValueAsString(traceDto));
        } catch (Exception e) {
            LOG.info("LOG: fail in" + e.getMessage());
        }
    }*/
}
