package com.maxs.pay.authentication.entity;

import jakarta.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Table(name = "users")
public class AuthUser {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String passwordHash;
    private String role;
    private Boolean active;
    private OffsetDateTime createdAt = OffsetDateTime.now();
    private OffsetDateTime updatedAt = OffsetDateTime.now();
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public String getEmail(){return email;} public void setEmail(String email){this.email=email;}
    public String getPasswordHash(){return passwordHash;} public void setPasswordHash(String passwordHash){this.passwordHash=passwordHash;}
    public String getRole(){return role;} public void setRole(String role){this.role=role;}
    public Boolean getActive(){return active;} public void setActive(Boolean active){this.active=active;}
}
