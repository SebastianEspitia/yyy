package com.porvenir.web;

import com.porvenir.domain.dto.ErrorDto;
import com.porvenir.exception.ApiException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AdviceControllerTest {

    @InjectMocks
    private AdviceController adviceController;

    @BeforeEach
    void setUp() {
    }

    @Test
    void apiExceptionHandler() {

        ResponseEntity<ErrorDto> test = adviceController.apiExceptionHandler(new ApiException("01", HttpStatus.OK, "OK"));
        Assertions.assertNotNull(test);
    }
}
