package com.maxs.pay.webhook.controller;
import com.maxs.pay.webhook.entity.WebhookLog; import com.maxs.pay.webhook.service.WebhookService; import com.maxs.pay.webhook.dto.*;
import org.springframework.http.ResponseEntity; import org.springframework.web.bind.annotation.*; import java.util.List;
@RestController @RequestMapping("/webhooks") public class WebhookController { private final WebhookService service; public WebhookController(WebhookService service){this.service=service;} @PostMapping("/payment-status") public ResponseEntity<WebhookLog> paymentStatus(@RequestBody PaymentStatusWebhookRequest req,@RequestHeader("X-SIGNATURE") String sig){return ResponseEntity.ok(service.process(req,sig));}
 }