package com.maxs.pay.webhook.service;

import com.maxs.pay.webhook.dto.PaymentStatusWebhookRequest;
import com.maxs.pay.webhook.entity.WebhookLog;
import com.maxs.pay.webhook.repository.WebhookLogRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class WebhookService {
    private final WebhookLogRepository repository;
    private final SignatureVerifier signatureVerifier;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public WebhookService(WebhookLogRepository repository, SignatureVerifier signatureVerifier, KafkaTemplate<String, String> kafkaTemplate) {
        this.repository = repository;
        this.signatureVerifier = signatureVerifier;
        this.kafkaTemplate = kafkaTemplate;
    }

    public WebhookLog process(PaymentStatusWebhookRequest request, String signature){
        boolean ok = signatureVerifier.verify(request.paymentReferenceId() + request.status(), signature);
        WebhookLog log = new WebhookLog();
        log.setProvider(request.provider());
        log.setEventType("payment-status");
        log.setPayload(request.toString());
        log.setVerified(ok);
        WebhookLog saved = repository.save(log);
        kafkaTemplate.send("payment-" + request.status().toLowerCase(), request.paymentReferenceId());
        return saved;
    }
}
