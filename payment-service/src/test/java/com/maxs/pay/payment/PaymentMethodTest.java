package com.maxs.pay.payment;

import com.maxs.pay.payment.dto.PaymentMethod;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PaymentMethodTest {
    @Test
    void supportsUpi() {
        assertEquals("UPI", PaymentMethod.UPI.name());
    }
}
