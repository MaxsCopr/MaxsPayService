package com.maxs.pay.webhook.dto;
public record PaymentStatusWebhookRequest(String provider,String paymentReferenceId,String status) {}
