package com.porvenir.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.porvenir.domain.dto.ErrorDto;
import com.porvenir.exception.ApiException;

@RestControllerAdvice
public class AdviceController {

    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity<ErrorDto> apiExceptionHandler (ApiException apiRuntime)  {
        return new ResponseEntity<> (ErrorDto.builder()
                .code(apiRuntime.getCode())
                .message(apiRuntime.getMessage())
                .build(),
                apiRuntime.getHttpStatus());
    }
}
