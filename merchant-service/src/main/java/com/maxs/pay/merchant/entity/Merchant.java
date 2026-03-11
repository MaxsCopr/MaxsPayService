package com.maxs.pay.merchant.entity;

import jakarta.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "merchants")
public class Merchant {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String upiVpa;
    private String settlementAccount;
    private String status;
    private OffsetDateTime createdAt = OffsetDateTime.now();
    private OffsetDateTime updatedAt = OffsetDateTime.now();
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public String getName(){return name;} public void setName(String name){this.name=name;}
    public String getUpiVpa(){return upiVpa;} public void setUpiVpa(String upiVpa){this.upiVpa=upiVpa;}
    public String getSettlementAccount(){return settlementAccount;} public void setSettlementAccount(String settlementAccount){this.settlementAccount=settlementAccount;}
    public String getStatus(){return status;} public void setStatus(String status){this.status=status;}
}
