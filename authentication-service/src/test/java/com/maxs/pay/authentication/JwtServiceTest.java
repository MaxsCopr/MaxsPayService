package com.maxs.pay.authentication;

import com.maxs.pay.authentication.service.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.test.util.ReflectionTestUtils;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class JwtServiceTest {
    @Test
    void shouldGenerateToken() {
        JwtService jwtService = new JwtService();
        ReflectionTestUtils.setField(jwtService, "secret", "01234567890123456789012345678901");
        assertNotNull(jwtService.generate("user@maxs.com", "CUSTOMER"));
    }
}
