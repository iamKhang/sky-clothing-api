package com.iamkhangg.skyclothingapi.repositories;

import com.iamkhangg.skyclothingapi.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
}
