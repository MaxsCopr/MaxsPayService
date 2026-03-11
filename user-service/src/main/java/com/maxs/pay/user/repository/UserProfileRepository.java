package com.maxs.pay.user.repository;

import com.maxs.pay.user.entity.UserProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserProfileRepository extends JpaRepository<UserProfile,Long> {  }
