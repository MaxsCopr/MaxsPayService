package com.maxs.pay.authentication.dto;
public record LoginRequest(@jakarta.validation.constraints.Email String email,String password) {}
