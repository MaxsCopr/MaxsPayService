package com.maxs.pay.authentication.dto;
public record AuthResponse(String accessToken,String refreshToken,String tokenType,long expiresIn) {}
