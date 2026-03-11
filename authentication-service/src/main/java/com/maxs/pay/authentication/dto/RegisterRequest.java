package com.maxs.pay.authentication.dto;
public record RegisterRequest(@jakarta.validation.constraints.Email String email,@jakarta.validation.constraints.Size(min=8) String password,String role) {}
