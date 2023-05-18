package com.porvenir.interceptor.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class HeadersConstantsTest {

    @InjectMocks
    private HeadersConstants headersConstants;

    @BeforeEach
    void setUp() {
    }


    HeadersConstantsTest() {
        //when(this).thenThrow(new IllegalStateException("Utility class"));
        //headersConstants.

        Mockito.mockStatic(HeadersConstants.class);

        //try (MockedConstruction mocked = mockConstruction(HeadersConstants.class)) {
            //Foo foo = new Foo();
            //when(foo.method()).thenReturn("bar");
            //assertEquals("bar", foo.method());
            //verify(new HeadersConstants());
        //}
    }
}
