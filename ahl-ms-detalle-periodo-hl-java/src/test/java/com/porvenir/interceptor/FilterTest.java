package com.porvenir.interceptor;

import com.porvenir.interceptor.dto.LoggerDto;
import com.porvenir.interceptor.integration.dto.TraceDto;
import com.porvenir.interceptor.integration.mapper.TraceMapper;
import com.porvenir.interceptor.service.TraceService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import javax.servlet.ServletException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FilterTest {

    @InjectMocks
    private Filter filter;

    @Mock
    private TraceService traceService;
    @Mock
    private TraceMapper traceMapper;

    private LoggerDto loggerDto;
    private TraceDto traceDto;

    @BeforeEach
    void setUp() {

        loggerDto = LoggerDto.builder().traceId("1").channel("1").idClientAplication("1").typeIdPerson("1").idPerson("1").nameComponent("1").urlServices("1").ip("1").idServices("1").parametersIn("1").parametersOut("1").codeResponse("1").messageResponse("1").detailTrace("1").build();
       // traceDto = TraceDto.builder().traceId("1").channel("1").idClientAplication("1").typeIdPerson("1").idPerson("1").nameComponent("1").urlServices("1").ipRequest("1").idServices("1").parametersIn("1").parametersOut("1").codeResponse("1").messageResponse("1").detailTrace("1").timeConsumeService(1L).timeResponseService(1L).build();
    }

    @Test
    void doFilter() throws IOException, ServletException {

        /*MockHttpServletRequest httpServletRequestGood = new MockHttpServletRequest();
        httpServletRequestGood.setMethod("POST");
        MockHttpServletResponse httpServletResponseGood = new MockHttpServletResponse();
        MockFilterChain filterChainGood = new MockFilterChain();

        when(traceMapper.toTrace(Mockito.any())).thenReturn(traceDto);
        doNothing().when(traceService).registerTrace(Mockito.any());
        filter.doFilter(httpServletRequestGood, httpServletResponseGood, filterChainGood);
        verify(traceService).registerTrace(Mockito.any());

        httpServletRequestGood.setMethod("GET");
        MockFilterChain filterChainGood2 = new MockFilterChain();
        filter.doFilter(httpServletRequestGood, httpServletResponseGood, filterChainGood2);

        httpServletRequestGood.setMethod("DELETE");
        MockFilterChain filterChainGood3 = new MockFilterChain();
        filter.doFilter(httpServletRequestGood, httpServletResponseGood, filterChainGood3);

        MockHttpServletRequest httpServletRequestBad = new MockHttpServletRequest();
        MockHttpServletResponse httpServletResponseBad = new MockHttpServletResponse();
        httpServletRequestBad.setMethod(null);

        when(traceMapper.toTrace(Mockito.any())).thenReturn(null);
        assertThrows(Exception.class, () -> {
            filter.doFilter(httpServletRequestBad, httpServletResponseBad, null);
        });*/
    }
}
