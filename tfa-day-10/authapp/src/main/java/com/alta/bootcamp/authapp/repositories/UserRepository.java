package com.alta.bootcamp.authapp.repositories;

import com.alta.bootcamp.authapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> getUserById(Long id);
  Optional<User> findByPhone(String phone);
  Optional<User> findByUsernameOrPhone(String username, String phone);
  List<User> findByIdIn(List<Long> userIds);
  Optional<User> findByUsername(String username);
  Boolean existsByUsername(String username);
  Boolean existsByPhone(String phone);
}
