package com.porvenir.interceptor.integration;

import com.porvenir.interceptor.integration.dto.TraceDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

//@FeignClient(value = "soa-ms-logs-trace-azure-java", url = "http://127.0.0.1:6000/cdc/general/v1/eventos/trace/")
//@FeignClient(value = "calculoSemanas", url ="${param.trace.logs.endpointws.savelogs}")
public interface TraceIntegration {


  /*  @PostMapping(value = "/")
    ResponseEntity save(@Valid @RequestBody TraceDto TraceDto);*/
}
