package com.maxs.pay.notification.controller;
import com.maxs.pay.notification.entity.NotificationLog; import com.maxs.pay.notification.service.NotificationService; import com.maxs.pay.notification.dto.*;
import org.springframework.http.ResponseEntity; import org.springframework.web.bind.annotation.*; import java.util.List;
@RestController @RequestMapping("/notifications") public class NotificationController { private final NotificationService service; public NotificationController(NotificationService service){this.service=service;} @PostMapping("/dispatch") public ResponseEntity<NotificationLog> dispatch(@RequestBody NotificationRequest req){return ResponseEntity.ok(service.dispatch(req));}
 }