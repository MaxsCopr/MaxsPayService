package com.maxs.pay.payment.controller;
import com.maxs.pay.payment.entity.Payment; import com.maxs.pay.payment.service.PaymentService; import com.maxs.pay.payment.dto.*;
import org.springframework.http.ResponseEntity; import org.springframework.web.bind.annotation.*; import java.util.List;
@RestController @RequestMapping("/payments") public class PaymentController { private final PaymentService service; public PaymentController(PaymentService service){this.service=service;} @PostMapping("/create") public ResponseEntity<Payment> create(@RequestBody CreatePaymentRequest req){return ResponseEntity.ok(service.create(req));}
    @GetMapping("/{id}") public ResponseEntity<Payment> get(@PathVariable Long id){return ResponseEntity.ok(service.get(id));}
    @PostMapping("/cancel") public ResponseEntity<Payment> cancel(@RequestParam Long id){return ResponseEntity.ok(service.cancel(id));}
 }