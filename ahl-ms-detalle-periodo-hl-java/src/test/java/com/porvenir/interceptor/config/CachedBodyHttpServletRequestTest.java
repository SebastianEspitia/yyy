package com.porvenir.interceptor.config;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CachedBodyHttpServletRequestTest {

    @InjectMocks
    private CachedBodyHttpServletRequest cachedBodyHttpServletRequest = new CachedBodyHttpServletRequest(new MockHttpServletRequest());
    CachedBodyHttpServletRequestTest() throws IOException { }

    @BeforeEach
    void setUp() {
    }

    @Test
    void getInputStream() throws IOException {

        Assertions.assertNotNull(cachedBodyHttpServletRequest.getInputStream());
    }

    @Test
    void getReader() throws IOException {

        Assertions.assertNotNull(cachedBodyHttpServletRequest.getReader());
    }
}
