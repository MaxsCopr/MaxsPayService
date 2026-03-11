package com.maxs.pay.webhook.repository;

import com.maxs.pay.webhook.entity.WebhookLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebhookLogRepository extends JpaRepository<WebhookLog,Long> {  }
