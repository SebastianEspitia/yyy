package com.porvenir.interceptor;

import com.porvenir.interceptor.dto.LoggerDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.doNothing;

@ExtendWith(MockitoExtension.class)
class GeneralInterceptorTest {

    @InjectMocks
    private GeneralInterceptor generalInterceptor;

    @Mock
    LoggerDto loggerDto = LoggerDto.getInstance();

    private Map<String, String> headers;

    @BeforeEach
    void setUp() {

        headers = new HashMap<>();
        headers.put("x-rquid", "1");
        headers.put("x-channel", "1");
        headers.put("x-CompanyId", "1");
        headers.put("X-GovIssueIdentType", "1");
        headers.put("X-IdentSerialNum", "1");
        headers.put("X-IPAddr", null);
    }

    @Test
    void preHandle() throws Exception {

        HttpServletResponse httpServletResponseGood = new MockHttpServletResponse();
        MockHttpServletRequest httpServletRequestGood = new MockHttpServletRequest();
        httpServletRequestGood.setMethod("OPTIONS");
        httpServletRequestGood.addHeader("x-rquid", 1);
        httpServletRequestGood.addHeader("x-channel", 1);
        httpServletRequestGood.addHeader("x-companyid", 1);
        httpServletRequestGood.addHeader("x-govissueidenttype", 1);
        httpServletRequestGood.addHeader("x-identserialnum", 1);
        httpServletRequestGood.addHeader("x-ipaddr", 1);

        boolean genPost = generalInterceptor.preHandle(httpServletRequestGood, httpServletResponseGood, null);
        Assertions.assertTrue(genPost);

        httpServletRequestGood.setMethod("GET");
        httpServletRequestGood.removeHeader("x-ipaddr");
        httpServletRequestGood.addHeader("X-IPAddr", 1);
        httpServletRequestGood.setRemoteAddr("");
        boolean genGet = generalInterceptor.preHandle(httpServletRequestGood, httpServletResponseGood, null);
        Assertions.assertTrue(genGet);

        httpServletRequestGood.setMethod("DELETE");
        httpServletRequestGood.removeHeader("x-identserialnum");
        httpServletRequestGood.addHeader("X-IdentSerialNum", 1);
        httpServletRequestGood.addHeader("x-forwarded-for", 1);
        boolean genDelete = generalInterceptor.preHandle(httpServletRequestGood, httpServletResponseGood, null);
        Assertions.assertTrue(genDelete);

        httpServletRequestGood.setMethod(null);
        httpServletRequestGood.removeHeader("x-govissueidenttype");
        httpServletRequestGood.addHeader("X-GovIssueIdentType", 1);
        boolean genCatch = generalInterceptor.preHandle(httpServletRequestGood, httpServletResponseGood, null);
        Assertions.assertTrue(genCatch);

        httpServletRequestGood.setRequestURI("swagger");
        boolean genSwagger = generalInterceptor.preHandle(httpServletRequestGood, httpServletResponseGood, null);
        Assertions.assertTrue(genSwagger);

        httpServletRequestGood.setRequestURI("api-docs");
        boolean genApiDocs = generalInterceptor.preHandle(httpServletRequestGood, httpServletResponseGood, null);
        Assertions.assertTrue(genApiDocs);
    }

    @Test
    void postHandle() throws Exception {

        HttpServletResponse httpServletResponseGood = new MockHttpServletResponse();
        MockHttpServletRequest httpServletRequestGood = new MockHttpServletRequest();

        generalInterceptor.postHandle(httpServletRequestGood, httpServletResponseGood, null, null);
    }

    @Test
    void afterCompletion() throws Exception {

        HttpServletResponse httpServletResponseGood = new MockHttpServletResponse();
        MockHttpServletRequest httpServletRequestGood = new MockHttpServletRequest();
        doNothing().when(loggerDto).setTimeResponseService(Mockito.anyLong());
        generalInterceptor.afterCompletion(httpServletRequestGood, httpServletResponseGood, null, null);
    }

    @Test
    void validateHeaders() {

        MockHttpServletResponse httpServletResponseGood = new MockHttpServletResponse();

        Assertions.assertFalse(generalInterceptor.validateHeaders(headers, null));

        headers.remove("x-channel");
        headers.put("X-Channel", "1");
        Assertions.assertFalse(generalInterceptor.validateHeaders(headers, httpServletResponseGood));

        headers.remove("x-rquid");
        headers.put("x-RQuID", "1");
        Assertions.assertFalse(generalInterceptor.validateHeaders(headers, httpServletResponseGood));
    }

    @Test
    void setIpAddress() {

        MockHttpServletRequest httpServletRequestGood = new MockHttpServletRequest();
        headers.remove("X-IPAddr");
        headers.put("x-ipaddr", "");
        headers.put("x-forwarded-for", "");
        httpServletRequestGood.setRemoteAddr(null);
        generalInterceptor.setIpAddress(headers, httpServletRequestGood);
    }
}
