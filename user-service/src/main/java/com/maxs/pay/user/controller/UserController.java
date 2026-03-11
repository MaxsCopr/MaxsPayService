package com.maxs.pay.user.controller;
import com.maxs.pay.user.entity.UserProfile; import com.maxs.pay.user.service.UserProfileService; 
import org.springframework.http.ResponseEntity; import org.springframework.web.bind.annotation.*; import java.util.List;
@RestController @RequestMapping("/users") public class UserController { private final UserProfileService service; public UserController(UserProfileService service){this.service=service;} @GetMapping("/{id}") public ResponseEntity<UserProfile> getById(@PathVariable Long id){return ResponseEntity.ok(service.getById(id));}
    @PutMapping("/{id}") public ResponseEntity<UserProfile> update(@PathVariable Long id,@RequestBody UserProfile req){return ResponseEntity.ok(service.update(id, req));}
    @GetMapping("/profile") public ResponseEntity<UserProfile> profile(@RequestHeader("X-USER-ID") Long id){return ResponseEntity.ok(service.getById(id));}
    @GetMapping public ResponseEntity<List<UserProfile>> list(){return ResponseEntity.ok(service.list());}
 }