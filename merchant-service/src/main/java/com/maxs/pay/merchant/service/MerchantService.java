package com.maxs.pay.merchant.service;
import com.maxs.pay.merchant.entity.Merchant;import com.maxs.pay.merchant.exception.ResourceNotFoundException;import com.maxs.pay.merchant.repository.MerchantRepository;
import org.springframework.stereotype.Service;import java.util.List;
@Service public class MerchantService {
    private final MerchantRepository repository;
    public MerchantService(MerchantRepository repository){this.repository=repository;}
    public Merchant create(Merchant m){return repository.save(m);} public List<Merchant> list(){return repository.findAll();}
    public Merchant get(Long id){return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Merchant not found"));}
    public List<String> transactionReport(Long id){return List.of("merchant-"+id+"-tx-report");}

}