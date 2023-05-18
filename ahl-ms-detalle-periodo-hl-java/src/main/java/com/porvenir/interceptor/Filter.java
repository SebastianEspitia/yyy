package com.porvenir.interceptor;

import com.porvenir.interceptor.dto.LoggerDto;
import com.porvenir.interceptor.integration.mapper.TraceMapper;
import com.porvenir.interceptor.service.TraceService;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.util.ContentCachingRequestWrapper;
import org.springframework.web.util.ContentCachingResponseWrapper;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@Component
public class Filter  {
/*extends GenericFilterBean
    @Autowired
    private TraceService traceService;

    @Autowired
    private TraceMapper traceMapper;

    private static final Logger LOG = LoggerFactory.getLogger(Filter.class);

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        LoggerDto loggerDto = LoggerDto.getInstance();
        ContentCachingRequestWrapper wrappedRequest = new ContentCachingRequestWrapper((HttpServletRequest) servletRequest);
        ContentCachingResponseWrapper responseWrapper = new ContentCachingResponseWrapper((HttpServletResponse) servletResponse);

        HttpServletResponse res = (HttpServletResponse) servletResponse;
        try {
            filterChain.doFilter(wrappedRequest, responseWrapper);
            if (!HttpMethod.GET.toString().equalsIgnoreCase(wrappedRequest.getMethod()) && !HttpMethod.DELETE.toString().equalsIgnoreCase(wrappedRequest.getMethod())) {
                byte[] requestArray = wrappedRequest.getContentAsByteArray();
                String requestStr = new String(requestArray, wrappedRequest.getCharacterEncoding());
                loggerDto.setParametersIn(requestStr);
            }
            byte[] responseArray=responseWrapper.getContentAsByteArray();
            String responseStr = new String(responseArray,responseWrapper.getCharacterEncoding());
            loggerDto.setParametersOut(responseStr);
            loggerDto.setCodeResponse(String.valueOf(res.getStatus()));
            responseWrapper.copyBodyToResponse();
            //
            //traceService.registerTrace(traceMapper.toTrace(loggerDto));
        }catch (Exception e) {
            if (!HttpMethod.GET.toString().equalsIgnoreCase(wrappedRequest.getMethod()) && !HttpMethod.DELETE.toString().equalsIgnoreCase(wrappedRequest.getMethod())) {
                byte[] requestArray = wrappedRequest.getContentAsByteArray();
                String requestStr = new String(requestArray, wrappedRequest.getCharacterEncoding());
                loggerDto.setParametersIn(requestStr);
            }
            byte[] responseArray=responseWrapper.getContentAsByteArray();
            String responseStr=new String(responseArray,responseWrapper.getCharacterEncoding());
            loggerDto.setParametersOut(responseStr);
            loggerDto.setCodeResponse(String.valueOf(responseWrapper.getStatus()));
            String stacktrace = ExceptionUtils.getStackTrace(e);
            loggerDto.setDetailTrace(stacktrace);
            responseWrapper.copyBodyToResponse();
            //
            //traceService.registerTrace(traceMapper.toTrace(loggerDto));
            //
            throw e;
        }

    }
*/
}