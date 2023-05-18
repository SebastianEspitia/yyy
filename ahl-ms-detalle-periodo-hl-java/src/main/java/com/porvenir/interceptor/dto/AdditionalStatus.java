package com.porvenir.interceptor.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdditionalStatus{

    private String serverStatusCode;
    private String severity;
    private String statusDesc;
}
