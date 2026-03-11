package com.maxs.pay.transaction.entity;

import com.maxs.pay.transaction.dto.PaymentStatus;
import jakarta.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "transactions")
public class TransactionRecord {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long paymentId;
    private Long userId;
    private String paymentReferenceId;
    @Enumerated(EnumType.STRING)
    private PaymentStatus status;
    private String auditLog;
    private OffsetDateTime createdAt = OffsetDateTime.now();
    private OffsetDateTime updatedAt = OffsetDateTime.now();
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public Long getPaymentId(){return paymentId;} public void setPaymentId(Long paymentId){this.paymentId=paymentId;}
    public Long getUserId(){return userId;} public void setUserId(Long userId){this.userId=userId;}
    public String getPaymentReferenceId(){return paymentReferenceId;} public void setPaymentReferenceId(String paymentReferenceId){this.paymentReferenceId=paymentReferenceId;}
    public PaymentStatus getStatus(){return status;} public void setStatus(PaymentStatus status){this.status=status;}
    public String getAuditLog(){return auditLog;} public void setAuditLog(String auditLog){this.auditLog=auditLog;}
}
