package com.maxs.pay.reconciliation.controller;
import com.maxs.pay.reconciliation.entity.ReconciliationReport; import com.maxs.pay.reconciliation.service.ReconciliationService; 
import org.springframework.http.ResponseEntity; import org.springframework.web.bind.annotation.*; import java.util.List;
@RestController @RequestMapping("/reconciliation") public class ReconciliationController { private final ReconciliationService service; public ReconciliationController(ReconciliationService service){this.service=service;} @GetMapping("/reports") public ResponseEntity<List<ReconciliationReport>> reports(){return ResponseEntity.ok(service.list());}
 }