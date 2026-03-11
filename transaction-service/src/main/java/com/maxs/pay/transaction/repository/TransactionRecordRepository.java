package com.maxs.pay.transaction.repository;

import com.maxs.pay.transaction.entity.TransactionRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRecordRepository extends JpaRepository<TransactionRecord,Long> { java.util.List<TransactionRecord> findByUserId(Long userId); }
