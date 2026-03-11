package com.maxs.pay.merchant.repository;

import com.maxs.pay.merchant.entity.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MerchantRepository extends JpaRepository<Merchant,Long> {  }
