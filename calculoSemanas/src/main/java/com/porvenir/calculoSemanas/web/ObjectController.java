package com.porvenir.calculoSemanas.web;


import com.porvenir.calculoSemanas.domain.dto.ResponseDto;
import com.porvenir.calculoSemanas.domain.dto.StatusDto;
import com.porvenir.calculoSemanas.domain.service.impl.ObjectServiceImpl;
import com.porvenir.calculoSemanas.util.Constan;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/controller")
public class ObjectController {

    @Autowired
    ObjectServiceImpl objectServiceImpl;

    Constan constan;

    @GetMapping(value = "/calculo")
    public ResponseEntity<ResponseDto> getCalculoSemanas(@RequestParam Integer numeroCuenta) {
        objectServiceImpl.getAllDetalleSemanas(numeroCuenta);
        ResponseDto responseDto = new ResponseDto();
        StatusDto statusDto = new StatusDto();
        statusDto.setStatusCode(constan.CODE_SUCCESS);
        statusDto.setStatusDesc(constan.SUCCESS);
        responseDto.setStatus(statusDto);
        return new ResponseEntity<>(responseDto, HttpStatus.OK);
    }

}
