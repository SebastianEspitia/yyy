package com.porvenir.domain.service;

import com.porvenir.domain.dto.ResponseStatusServiceDto;

public interface HealthService {

    ResponseStatusServiceDto ping();
}