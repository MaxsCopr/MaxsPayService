package com.maxs.pay.transaction.service;
import com.maxs.pay.transaction.entity.TransactionRecord;import com.maxs.pay.transaction.exception.ResourceNotFoundException;import com.maxs.pay.transaction.repository.TransactionRecordRepository;
import org.springframework.stereotype.Service;import java.util.List;
@Service public class TransactionService {
    private final TransactionRecordRepository repository;
    public TransactionService(TransactionRecordRepository repository){this.repository=repository;}
    public List<TransactionRecord> list(){return repository.findAll();}
    public TransactionRecord byId(Long id){return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Transaction not found"));}
    public List<TransactionRecord> byUser(Long id){return repository.findByUserId(id);}
}