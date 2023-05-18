package com.porvenir.web;

import com.porvenir.domain.dto.PersonDto;
import com.porvenir.domain.service.ObjectService;
import com.porvenir.exception.ApiException;
import com.porvenir.persistence.entity.CtaCuentaAporteEntity;
import com.porvenir.persistence.entity.VlaVidaLaboralAfpEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@CrossOrigin(origins = "${server.config.cors}")
public class ObjectController {

    @Autowired
    private ObjectService objectService;

    @Operation(summary = "obtine el detalle de los periodos laborales")
    @Parameters({
            @Parameter(in = ParameterIn.HEADER, name = "X-RqUID", schema = @Schema(type = "string"), description = "header X-RqUID Id de request para efectos de traza y correlacion de transacciones"),
            @Parameter(in = ParameterIn.HEADER, name = "X-Channel", schema = @Schema(type = "string"), description = "header X-Channel canal desde donde se consume el servicio"),
            @Parameter(in = ParameterIn.HEADER, name = "X-IdentSerialNum", schema = @Schema(type = "string"), description = "header X-IdentSerialNum numero identificacion del afiliado para efectos de traza"),
            @Parameter(in = ParameterIn.HEADER, name = "X-GovIssueIdentType", schema = @Schema(type = "string"), description = "header X-GovIssueIdentType tipo de identificacion del afiliado para efectos de traza"),
            @Parameter(in = ParameterIn.HEADER, name = "X-IPAddr", schema = @Schema(type = "string"),description = "header X-IPAddr Ip desde donde se consume el servicio para efecto de trazas"),
            @Parameter(in = ParameterIn.HEADER, name = "X-CompanyId", schema = @Schema(type = "string"),description = "header X-CompanyId Nombre o identificador de la compañia que realiza el consumo del servicio"),
            @Parameter(in = ParameterIn.HEADER, name = "Authorization", schema = @Schema(type = "string"),description = "header Authorization JWT para consumir el servicio cuando este se encuentra desplegado tras un APIM")
    })
    @ApiResponses({
            @ApiResponse(responseCode = "200", content = {
                    @Content(schema = @Schema(implementation = PersonDto.class),mediaType = "application/json")
            },description = "Respuesta Exitosa"),
            @ApiResponse(responseCode = "206", content = {
                    @Content(schema = @Schema(implementation = PersonDto.class),mediaType = "application/json")
            },description = "Solicitud procesada exitosamente pero no se encontro informacion, los valores de los campos vendra vacios"),
            @ApiResponse(responseCode = "400", content = {
                    @Content(schema = @Schema(implementation = ApiException.class),mediaType = "application/json")
            },description = "El request no presenta los parametros requeridos por transaccion"),
            @ApiResponse(responseCode = "401", content = {
                    @Content(schema = @Schema(implementation = ApiException.class),mediaType = "application/json")
            },description = "El request no presenta los parametros requeridos por transaccion"),
            @ApiResponse(responseCode = "500", content = {
                    @Content(schema = @Schema(implementation = ApiException.class),mediaType = "application/json")
            },description = "Se presenta un error interno")
    })
    @GetMapping(value = "/periodDetailHl")
    public List<VlaVidaLaboralAfpEntity> periodDetail(@RequestParam Integer numeroCuenta) {
        //return objectService.functionCtaCuentaAporte(numeroCuenta);
        return objectService.functionCtaCuentaAporte2(numeroCuenta);
    }


}