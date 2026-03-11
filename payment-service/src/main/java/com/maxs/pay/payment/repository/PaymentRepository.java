package com.maxs.pay.payment.repository;

import com.maxs.pay.payment.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment,Long> {  }
