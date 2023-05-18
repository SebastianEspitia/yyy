package com.porvenir.interceptor.config;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ContentCachingFilterTest {

    @InjectMocks
    private ContentCachingFilter contentCachingFilter;

    @BeforeEach
    void setUp() {
    }

    @Test
    void doFilterInternal() throws ServletException, IOException {

        HttpServletRequest httpServletRequest = new MockHttpServletRequest();
        HttpServletResponse httpServletResponse = new MockHttpServletResponse();
        FilterChain filterChain = new MockFilterChain();

        contentCachingFilter.doFilterInternal(httpServletRequest, httpServletResponse, filterChain);
    }
}
