package com.porvenir.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;

@NoArgsConstructor
@Setter
@Getter
@Builder
@AllArgsConstructor
public class ResponseStatusServiceDto {

    private String status;

    private String appName;

    private String version;

    private String buildDate;

}