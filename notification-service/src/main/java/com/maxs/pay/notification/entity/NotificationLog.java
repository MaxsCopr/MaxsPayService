package com.maxs.pay.notification.entity;

import jakarta.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "notification_logs")
public class NotificationLog {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String eventType;
    private String channel;
    private String target;
    private String message;
    private OffsetDateTime createdAt = OffsetDateTime.now();
    private OffsetDateTime updatedAt = OffsetDateTime.now();
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public String getEventType(){return eventType;} public void setEventType(String eventType){this.eventType=eventType;}
    public String getChannel(){return channel;} public void setChannel(String channel){this.channel=channel;}
    public String getTarget(){return target;} public void setTarget(String target){this.target=target;}
    public String getMessage(){return message;} public void setMessage(String message){this.message=message;}
}
