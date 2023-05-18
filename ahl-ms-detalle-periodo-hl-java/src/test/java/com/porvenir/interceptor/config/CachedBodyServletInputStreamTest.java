package com.porvenir.interceptor.config;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.servlet.ReadListener;
import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.doCallRealMethod;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CachedBodyServletInputStreamTest {

    @InjectMocks
    private CachedBodyServletInputStream cachedBodyServletInputStream = new CachedBodyServletInputStream(new byte[] { 0 });

    @Mock
    private InputStream cachedBodyInputStream;

    @Test
    void isFinished() throws IOException {

        when(cachedBodyInputStream.available()).thenReturn(1);
        Assertions.assertFalse(cachedBodyServletInputStream.isFinished());

        when(cachedBodyInputStream.available()).thenReturn(0);
        Assertions.assertTrue(cachedBodyServletInputStream.isFinished());

        when(cachedBodyServletInputStream.isFinished()).thenThrow(IOException.class);
        Assertions.assertFalse(cachedBodyServletInputStream.isFinished());
    }

    @Test
    void isReady() {

        Assertions.assertTrue(cachedBodyServletInputStream.isReady());
    }

    @Test
    void setReadListener() {

        cachedBodyServletInputStream = mock(CachedBodyServletInputStream.class);
        doCallRealMethod().when(cachedBodyServletInputStream).setReadListener(Mockito.any());
        assertThrows(UnsupportedOperationException.class, () -> {
            cachedBodyServletInputStream.setReadListener(Mockito.any(ReadListener.class));
        });
    }

    @Test
    void read() throws IOException {

        when(cachedBodyInputStream.read()).thenReturn(1);
        Assertions.assertEquals(1, cachedBodyServletInputStream.read());
    }
}
