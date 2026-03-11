package com.maxs.pay.payment.dto;
public record CreatePaymentRequest(Long userId,Long merchantId,java.math.BigDecimal amount,PaymentMethod paymentMethod) {}
