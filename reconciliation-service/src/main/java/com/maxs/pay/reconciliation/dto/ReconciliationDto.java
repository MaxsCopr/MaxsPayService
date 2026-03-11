package com.maxs.pay.reconciliation.dto;
public record ReconciliationDto(Long id,java.time.LocalDate reconcileDate,int matchedCount,int mismatchCount) {}
