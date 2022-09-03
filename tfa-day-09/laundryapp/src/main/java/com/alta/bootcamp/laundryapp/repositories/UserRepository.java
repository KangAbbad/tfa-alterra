package com.alta.bootcamp.laundryapp.repositories;

import com.alta.bootcamp.laundryapp.dto.UserResponseDTO;
import com.alta.bootcamp.laundryapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  User getUserById(Long id);
}
