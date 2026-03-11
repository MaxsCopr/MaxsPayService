package com.maxs.pay.admin.entity;

import jakarta.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "admin_reports")
public class AdminReport {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String reportType;
    @Column(length = 2000)
    private String reportData;
    private OffsetDateTime createdAt = OffsetDateTime.now();
    private OffsetDateTime updatedAt = OffsetDateTime.now();
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public String getReportType(){return reportType;} public void setReportType(String reportType){this.reportType=reportType;}
    public String getReportData(){return reportData;} public void setReportData(String reportData){this.reportData=reportData;}
}
