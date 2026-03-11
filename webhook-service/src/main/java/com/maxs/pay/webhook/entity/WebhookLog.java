package com.maxs.pay.webhook.entity;

import jakarta.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "webhook_logs")
public class WebhookLog {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String provider;
    private String eventType;
    @Column(length = 2000)
    private String payload;
    private Boolean verified;
    private OffsetDateTime createdAt = OffsetDateTime.now();
    private OffsetDateTime updatedAt = OffsetDateTime.now();
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public String getProvider(){return provider;} public void setProvider(String provider){this.provider=provider;}
    public String getEventType(){return eventType;} public void setEventType(String eventType){this.eventType=eventType;}
    public String getPayload(){return payload;} public void setPayload(String payload){this.payload=payload;}
    public Boolean getVerified(){return verified;} public void setVerified(Boolean verified){this.verified=verified;}
}
