package com.maxs.pay.reconciliation.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.OffsetDateTime;

@Entity
@Table(name = "settlements")
public class ReconciliationReport {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate reconcileDate;
    private Integer matchedCount;
    private Integer mismatchCount;
    @Column(length = 2000)
    private String mismatchDetails;
    private OffsetDateTime createdAt = OffsetDateTime.now();
    private OffsetDateTime updatedAt = OffsetDateTime.now();
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public LocalDate getReconcileDate(){return reconcileDate;} public void setReconcileDate(LocalDate reconcileDate){this.reconcileDate=reconcileDate;}
    public Integer getMatchedCount(){return matchedCount;} public void setMatchedCount(Integer matchedCount){this.matchedCount=matchedCount;}
    public Integer getMismatchCount(){return mismatchCount;} public void setMismatchCount(Integer mismatchCount){this.mismatchCount=mismatchCount;}
    public String getMismatchDetails(){return mismatchDetails;} public void setMismatchDetails(String mismatchDetails){this.mismatchDetails=mismatchDetails;}
}
