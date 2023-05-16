package com.porvenir.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.porvenir.interceptor.dto.LoggerDto;
import com.porvenir.interceptor.dto.ObjectResponseDTO;
import com.porvenir.interceptor.util.HeadersConstants;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class GeneralInterceptor implements HandlerInterceptor {

    @Value("${name.component}")
    private String NAME_COMPONENT;
    @Value("${id.service}")
    private String ID_SERVICE;

    LoggerDto loggerDto = LoggerDto.getInstance();
    Map<String, String> headers;
    Map<String, String> params;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getRequestURI().contains("swagger") || request.getRequestURI().contains("api-docs")) {
            return true;
        }

        // Se validan los Headers requeridos
        getHeaders(request);
        validateHeaders(headers, response);
        // Metodo options
        if(request.getMethod() != null && request.getMethod().equals("OPTIONS")) {
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.setStatus(HttpServletResponse.SC_OK);
        }
        // Se construye dto logger
        try {
            buildLoggerPreHandle(request);
        } catch (Exception e) {
            ObjectMapper mapper = new ObjectMapper();
            ObjectResponseDTO generalResponse = new ObjectResponseDTO();
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write(mapper.writeValueAsString(generalResponse.error(loggerDto, "Error al obtener el body de la peticion")));
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        // To allow sonar
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        loggerDto.setTimeResponseService(new Date().getTime());
    }

    public void getHeaders(HttpServletRequest request) {
        headers = new HashMap<>();
        Collections.list(request.getHeaderNames()).forEach(header -> headers.put(header, request.getHeader(header)));
    }

    public ObjectResponseDTO buildGeneralResponseErrorHeadersRequired(String name) {
        ObjectResponseDTO objectResponseDTO = new ObjectResponseDTO();
        return objectResponseDTO.error(loggerDto, name);
    }

    public void buildLoggerPreHandle(HttpServletRequest request) {
        loggerDto.setTraceId(headers.get(HeadersConstants.X_RQUID.toLowerCase()));
        loggerDto.setChannel(headers.get(HeadersConstants.X_CHANNEL.toLowerCase()));
        //
        loggerDto.setTypeIdPerson(headers.get(HeadersConstants.X_GOV_ISSUE_IDENT_TYPE.toLowerCase()));
        loggerDto.setIdPerson(headers.get(HeadersConstants.X_IDENT_SERIAL_NUM.toLowerCase()));
        //
        loggerDto.setNameComponent(NAME_COMPONENT);
        loggerDto.setUrlServices(request.getMethod().concat(": ").concat(request.getRequestURI()));
        loggerDto.setIdServices(ID_SERVICE);
        loggerDto.setParametersIn(buildParametersInByHttpMethod(request));
        loggerDto.setTimeConsumeService(new Date().getTime());
        //
        setIpAddress(headers, request);
    }

    public String buildParametersInByHttpMethod(HttpServletRequest request) {
        String parametersIn = null;
        if (HttpMethod.GET.toString().equalsIgnoreCase(request.getMethod()) || HttpMethod.DELETE.toString().equalsIgnoreCase(request.getMethod()))
            parametersIn = getParams(request);
        return parametersIn;
    }

    public String getParams(HttpServletRequest request) {
        params = new HashMap<>();
        Collections.list(request.getParameterNames()).forEach(param -> params.put(param, request.getParameter(param)));
        return params.toString();
    }

    public boolean validateHeaders(Map<String, String> headers, HttpServletResponse response) {
        boolean isValid = true;
        //
        if (!headers.containsKey(HeadersConstants.X_RQUID.toLowerCase())
                || !headers.containsKey(HeadersConstants.X_CHANNEL.toLowerCase())
                || !headers.containsKey(HeadersConstants.X_COMPANY_ID.toLowerCase())
                || !headers.containsKey(HeadersConstants.X_GOV_ISSUE_IDENT_TYPE.toLowerCase())
                || !headers.containsKey(HeadersConstants.X_IDENT_SERIAL_NUM.toLowerCase())
                || !headers.containsKey(HeadersConstants.X_IP_ADDR.toLowerCase())
        ) {
            ObjectMapper mapper = new ObjectMapper();
            ObjectResponseDTO generalResponse = buildGeneralResponseErrorHeadersRequired("Headers required");
            try {
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write(mapper.writeValueAsString(generalResponse));
            } catch (Exception ignored) {
                isValid = false;
            }
            isValid = false;
        }
        return isValid;
    }

    public void setIpAddress(Map<String, String> headers, HttpServletRequest request) {
        String ipAddress = headers.get(HeadersConstants.X_FORWARDED_FOR.toLowerCase());
        if (ipAddress == null || "".equals(ipAddress)) {
            ipAddress = headers.get(HeadersConstants.X_IP_ADDR.toLowerCase());
        }
        if (ipAddress == null || "".equals(ipAddress)) {
            ipAddress = request.getRemoteAddr();
        }
        if (ipAddress == null || "".equals(ipAddress)) {
            ipAddress = "Not Found";
        }
        loggerDto.setIp(ipAddress);
    }

}
