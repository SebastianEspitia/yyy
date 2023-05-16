package com.porvenir.interceptor.integration.mapper;

import com.porvenir.interceptor.dto.LoggerDto;
import com.porvenir.interceptor.integration.dto.TraceDto;
import org.springframework.stereotype.Component;

@Component
public class TraceMapperImpl implements TraceMapper {

    @Override
    public TraceDto toTrace(LoggerDto loggerDto) {
        return TraceDto.builder()
                .traceId(loggerDto.getTraceId() != null ? loggerDto.getTraceId() : "")
                .channel(loggerDto.getChannel() != null ? loggerDto.getChannel() : "")
                .idClientAplication(loggerDto.getIdClientAplication() != null ? loggerDto.getIdClientAplication() : "")
                .typeIdPerson(loggerDto.getTypeIdPerson() != null ? loggerDto.getTypeIdPerson() : "")
                .idPerson(loggerDto.getIdPerson() != null ? loggerDto.getIdPerson() : "")
                .nameComponent(loggerDto.getNameComponent() != null ? loggerDto.getNameComponent() : "")
                .urlServices(loggerDto.getUrlServices() != null ? loggerDto.getUrlServices() : "")
                .ipRequest(loggerDto.getIp() != null ? loggerDto.getIp() : "")
                .idServices(loggerDto.getIdServices() != null ? loggerDto.getIdServices() : "")
                .parametersIn(loggerDto.getParametersIn() != null ? loggerDto.getParametersIn() : "")
                .parametersOut(loggerDto.getParametersOut() != null ? loggerDto.getParametersOut() : "")
                .codeResponse(loggerDto.getCodeResponse() != null ? loggerDto.getCodeResponse() : "")
                .messageResponse(loggerDto.getMessageResponse() != null ? loggerDto.getMessageResponse() : "")
                .detailTrace(loggerDto.getDetailTrace() != null ? loggerDto.getDetailTrace() : "")
                .timeConsumeService(loggerDto.getTimeConsumeService())
                .timeResponseService(loggerDto.getTimeResponseService())
                .build();
    }

}
