package com.maxs.pay.payment.service;

import com.maxs.pay.payment.dto.CreatePaymentRequest;
import com.maxs.pay.payment.entity.Payment;
import com.maxs.pay.payment.exception.ResourceNotFoundException;
import com.maxs.pay.payment.repository.PaymentRepository;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PaymentService {
    private final PaymentRepository repository;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public PaymentService(PaymentRepository repository, KafkaTemplate<String, String> kafkaTemplate) {
        this.repository = repository;
        this.kafkaTemplate = kafkaTemplate;
    }

    public Payment create(CreatePaymentRequest req){
        Payment p = new Payment();
        p.setUserId(req.userId());
        p.setMerchantId(req.merchantId());
        p.setAmount(req.amount());
        p.setPaymentMethod(req.paymentMethod());
        p.setStatus("CREATED");
        p.setPaymentReferenceId("MAXPAY-" + UUID.randomUUID().toString().replace("-", "").substring(0, 16));
        Payment saved = repository.save(p);
        kafkaTemplate.send("payment-created", saved.getPaymentReferenceId());
        return saved;
    }

    public Payment get(Long id){ return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Payment not found")); }
    public Payment cancel(Long id){ Payment p = get(id); p.setStatus("CANCELLED"); return repository.save(p); }
}
