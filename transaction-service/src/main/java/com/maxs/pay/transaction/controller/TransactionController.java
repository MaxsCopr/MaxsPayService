package com.maxs.pay.transaction.controller;
import com.maxs.pay.transaction.entity.TransactionRecord; import com.maxs.pay.transaction.service.TransactionService; 
import org.springframework.http.ResponseEntity; import org.springframework.web.bind.annotation.*; import java.util.List;
@RestController @RequestMapping("/transactions") public class TransactionController { private final TransactionService service; public TransactionController(TransactionService service){this.service=service;} @GetMapping public ResponseEntity<List<TransactionRecord>> all(){return ResponseEntity.ok(service.list());}
    @GetMapping("/{id}") public ResponseEntity<TransactionRecord> byId(@PathVariable Long id){return ResponseEntity.ok(service.byId(id));}
    @GetMapping("/user/{userId}") public ResponseEntity<List<TransactionRecord>> byUser(@PathVariable Long userId){return ResponseEntity.ok(service.byUser(userId));}
 }