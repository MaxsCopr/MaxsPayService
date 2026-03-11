package com.maxs.pay.admin.service;
import com.maxs.pay.admin.entity.AdminReport;import com.maxs.pay.admin.exception.ResourceNotFoundException;import com.maxs.pay.admin.repository.AdminReportRepository;
import org.springframework.stereotype.Service;import java.util.List;
@Service public class AdminService {
    private final AdminReportRepository repository;
    public AdminService(AdminReportRepository repository){this.repository=repository;}
    public List<String> allTransactions(){return List.of("tx-1","tx-2");}
    public List<String> merchants(){return List.of("merchant-1","merchant-2");}
    public List<AdminReport> reports(){return repository.findAll();}

}