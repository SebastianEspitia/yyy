package com.porvenir.interceptor.dto;

import lombok.*;

import java.util.Date;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ObjectResponseDTO {
    private String err;
    private String statusCode;
    private String severity;
    private String statusDesc;
    private AdditionalStatus additionalStatus;
    private Date endDt;

    public ObjectResponseDTO error(LoggerDto loggerDto, String name){
        String[] out = {};
        if(loggerDto.getParametersOut() != null) {
            String log = loggerDto.getParametersOut().replace("}", "");
            log = log.replace("{", "");
            log = log.replace(":", "");
            log = log.replace(",", "");
            out = log.split("\"");
        }
        if(out.length >= 5){
            return ObjectResponseDTO.builder().
                    err(name).
                    statusCode(loggerDto.getCodeResponse()).
                    statusDesc(out[4]).
                    severity(out[2]).
                    additionalStatus(new AdditionalStatus(loggerDto.getCodeResponse(),out[2],out[4])).
                    endDt(new Date())
                    .build();
        }
        return ObjectResponseDTO.builder().build();
    }
}