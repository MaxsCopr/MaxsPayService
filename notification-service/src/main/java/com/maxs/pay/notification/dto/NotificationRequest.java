package com.maxs.pay.notification.dto;
public record NotificationRequest(String eventType,String channel,String target,String message) {}
