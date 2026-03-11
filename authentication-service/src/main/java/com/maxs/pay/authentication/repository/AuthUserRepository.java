package com.maxs.pay.authentication.repository;

import com.maxs.pay.authentication.entity.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthUserRepository extends JpaRepository<AuthUser,Long> { java.util.Optional<AuthUser> findByEmail(String email); }
