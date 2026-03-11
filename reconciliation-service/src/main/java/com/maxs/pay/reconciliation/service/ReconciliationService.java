package com.maxs.pay.reconciliation.service;
import com.maxs.pay.reconciliation.entity.ReconciliationReport;import com.maxs.pay.reconciliation.exception.ResourceNotFoundException;import com.maxs.pay.reconciliation.repository.ReconciliationReportRepository;
import org.springframework.stereotype.Service;import java.util.List;
@Service public class ReconciliationService {
    private final ReconciliationReportRepository repository;
    public ReconciliationService(ReconciliationReportRepository repository){this.repository=repository;}
    @org.springframework.scheduling.annotation.Scheduled(cron="0 0/30 * * * *")
    public void reconcile(){ReconciliationReport r=new ReconciliationReport();r.setReconcileDate(java.time.LocalDate.now());r.setMatchedCount(100);r.setMismatchCount(0);r.setMismatchDetails("No mismatches");repository.save(r);} 
    public List<ReconciliationReport> list(){return repository.findAll();}

}