package com.porvenir.interceptor.integration.dto;

import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TraceDto {
    @NonNull
    private String traceId;
    @NonNull
    private String channel;
    @NonNull
    private String idClientAplication;
    @NonNull
    private String typeIdPerson;
    @NonNull
    private String idPerson;
    @NonNull
    private String nameComponent;
    @NonNull
    private String urlServices;
    @NonNull
    private String ipRequest;
    @NonNull
    private String idServices;
    @NonNull
    private String parametersIn;
    @NonNull
    private String parametersOut;
    @NonNull
    private String codeResponse;
    @NonNull
    private String messageResponse;
    @NonNull
    private String detailTrace;
    @NonNull
    private Long timeConsumeService;
    @NonNull
    private Long timeResponseService;
}
