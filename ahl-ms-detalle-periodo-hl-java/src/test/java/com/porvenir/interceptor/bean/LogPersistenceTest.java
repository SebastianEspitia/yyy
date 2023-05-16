package com.porvenir.interceptor.bean;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class LogPersistenceTest {

    @InjectMocks
    private LogPersistenceImpl logPersistenceImpl;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getClientIdApplication() {

        Assertions.assertNull(logPersistenceImpl.getClientIdApplication());
    }

    @Test
    void isEnabled() {

        Assertions.assertFalse(logPersistenceImpl.isEnabled());
    }

    @Test
    void getEndpoint() {

        Assertions.assertNull(logPersistenceImpl.getEndpoint());
    }
}
