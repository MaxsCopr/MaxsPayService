package com.maxs.pay.notification.repository;

import com.maxs.pay.notification.entity.NotificationLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationLogRepository extends JpaRepository<NotificationLog,Long> {  }
