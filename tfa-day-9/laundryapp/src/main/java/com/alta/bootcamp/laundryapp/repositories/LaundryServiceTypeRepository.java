package com.alta.bootcamp.laundryapp.repositories;

import com.alta.bootcamp.laundryapp.entities.LaundryServiceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LaundryServiceTypeRepository extends JpaRepository<LaundryServiceType, Long> {
  LaundryServiceType getLaundryServiceTypeById(Long id);
}
