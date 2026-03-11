package com.maxs.pay.payment;

import com.maxs.pay.payment.dto.CreatePaymentRequest;
import com.maxs.pay.payment.dto.PaymentMethod;
import com.maxs.pay.payment.entity.Payment;
import com.maxs.pay.payment.repository.PaymentRepository;
import com.maxs.pay.payment.service.PaymentService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.kafka.core.KafkaTemplate;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

class PaymentServiceTest {
    @Test
    void createsPaymentWithReference() {
        PaymentRepository repo = Mockito.mock(PaymentRepository.class);
        KafkaTemplate<String, String> kafka = Mockito.mock(KafkaTemplate.class);
        PaymentService service = new PaymentService(repo, kafka);
        Mockito.when(repo.save(any(Payment.class))).thenAnswer(invocation -> invocation.getArgument(0));
        Payment result = service.create(new CreatePaymentRequest(1L, 2L, BigDecimal.TEN, PaymentMethod.UPI));
        assertEquals("CREATED", result.getStatus());
    }
}
