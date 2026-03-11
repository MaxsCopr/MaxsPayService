package com.maxs.pay.reconciliation.repository;

import com.maxs.pay.reconciliation.entity.ReconciliationReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReconciliationReportRepository extends JpaRepository<ReconciliationReport,Long> {  }
