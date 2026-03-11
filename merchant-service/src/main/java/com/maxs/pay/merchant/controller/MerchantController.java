package com.maxs.pay.merchant.controller;
import com.maxs.pay.merchant.entity.Merchant; import com.maxs.pay.merchant.service.MerchantService; 
import org.springframework.http.ResponseEntity; import org.springframework.web.bind.annotation.*; import java.util.List;
@RestController @RequestMapping("/merchants") public class MerchantController { private final MerchantService service; public MerchantController(MerchantService service){this.service=service;} @PostMapping public ResponseEntity<Merchant> create(@RequestBody Merchant m){return ResponseEntity.ok(service.create(m));}
    @GetMapping public ResponseEntity<List<Merchant>> list(){return ResponseEntity.ok(service.list());}
    @GetMapping("/{id}") public ResponseEntity<Merchant> get(@PathVariable Long id){return ResponseEntity.ok(service.get(id));}
    @GetMapping("/{id}/transactions") public ResponseEntity<List<String>> tx(@PathVariable Long id){return ResponseEntity.ok(service.transactionReport(id));}
 }