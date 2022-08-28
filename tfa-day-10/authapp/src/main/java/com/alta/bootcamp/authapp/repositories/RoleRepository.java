package com.alta.bootcamp.authapp.repositories;

import com.alta.bootcamp.authapp.entities.Role;
import com.alta.bootcamp.authapp.entities.RolesEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(RolesEnum roleName);
}