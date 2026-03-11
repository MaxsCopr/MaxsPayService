package com.maxs.pay.payment.entity;

import com.maxs.pay.payment.dto.PaymentMethod;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Entity
@Table(name = "payments")
public class Payment {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String paymentReferenceId;
    private Long userId;
    private Long merchantId;
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
    private BigDecimal amount;
    private String status;
    private OffsetDateTime createdAt = OffsetDateTime.now();
    private OffsetDateTime updatedAt = OffsetDateTime.now();
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public String getPaymentReferenceId(){return paymentReferenceId;} public void setPaymentReferenceId(String paymentReferenceId){this.paymentReferenceId=paymentReferenceId;}
    public Long getUserId(){return userId;} public void setUserId(Long userId){this.userId=userId;}
    public Long getMerchantId(){return merchantId;} public void setMerchantId(Long merchantId){this.merchantId=merchantId;}
    public PaymentMethod getPaymentMethod(){return paymentMethod;} public void setPaymentMethod(PaymentMethod paymentMethod){this.paymentMethod=paymentMethod;}
    public BigDecimal getAmount(){return amount;} public void setAmount(BigDecimal amount){this.amount=amount;}
    public String getStatus(){return status;} public void setStatus(String status){this.status=status;}
}
