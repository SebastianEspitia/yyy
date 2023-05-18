package com.porvenir.domain.service.impl;

import com.porvenir.domain.dto.ResponseStatusServiceDto;
import com.porvenir.config.ConfigVariable;
import com.porvenir.domain.service.HealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HealthServiceImpl implements HealthService {

    @Autowired
    private ConfigVariable configVariable;

    /**
     * Allow to know status of service(Proyect)
     * @return ResponseStatusServiceDto
     */
     @Override
    public ResponseStatusServiceDto ping() {
        return ResponseStatusServiceDto.builder()
                .status(configVariable.getApplicationName())
                .appName(configVariable.getApplicationName())
                .buildDate(configVariable.getBuildDate())
                .version(configVariable.getBuildVersion())
                .build();
    }
}