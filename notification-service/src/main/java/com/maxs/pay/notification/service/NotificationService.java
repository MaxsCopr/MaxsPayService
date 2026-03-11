package com.maxs.pay.notification.service;

import com.maxs.pay.notification.dto.NotificationRequest;
import com.maxs.pay.notification.entity.NotificationLog;
import com.maxs.pay.notification.repository.NotificationLogRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    private final NotificationLogRepository repository;

    public NotificationService(NotificationLogRepository repository) {
        this.repository = repository;
    }

    public NotificationLog dispatch(NotificationRequest req){
        NotificationLog n = new NotificationLog();
        n.setEventType(req.eventType());
        n.setChannel(req.channel());
        n.setTarget(req.target());
        n.setMessage(req.message());
        return repository.save(n);
    }

    @KafkaListener(topics = {"payment-success", "payment-failed", "refund-created", "settlement-completed"})
    public void consume(String payload){
        NotificationLog n = new NotificationLog();
        n.setEventType("ASYNC_EVENT");
        n.setChannel("PUSH");
        n.setTarget("system");
        n.setMessage(payload);
        repository.save(n);
    }
}
