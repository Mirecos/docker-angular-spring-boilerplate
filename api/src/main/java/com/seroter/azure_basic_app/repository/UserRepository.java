package com.seroter.azure_basic_app.repository;

import com.seroter.azure_basic_app.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    // Optionally add custom queries here
}
