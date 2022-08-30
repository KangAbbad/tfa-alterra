package com.alta.bootcamp.laundryapp.repositories;

import com.alta.bootcamp.laundryapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  User getUserById(Long id);
  Optional<User> findByPhone(String name);
}
