package com.alta.bootcamp.queueloggingapp.repositories;

import com.alta.bootcamp.queueloggingapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  User getUserById(Long id);
  Optional<User> findByEmail(String email);
  Optional<User> findByUsername(String username);
}
