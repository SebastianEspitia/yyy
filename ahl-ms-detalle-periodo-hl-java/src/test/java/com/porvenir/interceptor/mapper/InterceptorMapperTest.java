package com.porvenir.interceptor.mapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class InterceptorMapperTest {

    @InjectMocks
    private InterceptorMapperImpl interceptorMapperImpl;
    InterceptorMapperTest() {

    }

    @BeforeEach
    void setUp() {
    }
}
