package com.porvenir.web;

import com.porvenir.domain.dto.ResponseStatusServiceDto;
import com.porvenir.domain.service.HealthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping(value = "/api-health")
public class HealthController {

    @Autowired
    private HealthService healthService;

    @Operation(summary = "example responseEntity body and dependency resilence4J")
    @Parameters({
            @Parameter(in = ParameterIn.HEADER, name = "X-RqUID", schema = @Schema(type = "string"), description = "header X-RqUID Id de request para efectos de traza y correlacion de transacciones"),
            @Parameter(in = ParameterIn.HEADER, name = "X-Channel", schema = @Schema(type = "string"), description = "header X-Channel canal desde donde se consume el servicio"),
            @Parameter(in = ParameterIn.HEADER, name = "X-IdentSerialNum", schema = @Schema(type = "string"), description = "header X-IdentSerialNum numero identificacion del afiliado para efectos de traza"),
            @Parameter(in = ParameterIn.HEADER, name = "X-GovIssueIdentType", schema = @Schema(type = "string"), description = "header X-GovIssueIdentType tipo de identificacion del afiliado para efectos de traza"),
            @Parameter(in = ParameterIn.HEADER, name = "X-IPAddr", schema = @Schema(type = "string"),description = "header X-IPAddr Ip desde donde se consume el servicio para efecto de trazas"),
            @Parameter(in = ParameterIn.HEADER, name = "X-CompanyId", schema = @Schema(type = "string"),description = "header X-CompanyId Nombre o identificador de la compañia que realiza el consumo del servicio"),
            @Parameter(in = ParameterIn.HEADER, name = "Authorization", schema = @Schema(type = "string"),description = "header Authorization JWT para consumir el servicio cuando este se encuentra desplegado tras un APIM")
    })
    @GetMapping("/ping")
    public ResponseEntity<ResponseStatusServiceDto> ping() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(healthService.ping());
    }
}