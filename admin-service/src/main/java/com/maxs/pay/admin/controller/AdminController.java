package com.maxs.pay.admin.controller;
import com.maxs.pay.admin.entity.AdminReport; import com.maxs.pay.admin.service.AdminService; 
import org.springframework.http.ResponseEntity; import org.springframework.web.bind.annotation.*; import java.util.List;
@RestController @RequestMapping("/admin") public class AdminController { private final AdminService service; public AdminController(AdminService service){this.service=service;} @GetMapping("/transactions") public ResponseEntity<List<String>> transactions(){return ResponseEntity.ok(service.allTransactions());}
    @GetMapping("/merchants") public ResponseEntity<List<String>> merchants(){return ResponseEntity.ok(service.merchants());}
    @GetMapping("/reports") public ResponseEntity<List<AdminReport>> reports(){return ResponseEntity.ok(service.reports());}
 }