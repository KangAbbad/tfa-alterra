package com.alta.bootcamp.excelgeneratorapp.repositories;

import com.alta.bootcamp.excelgeneratorapp.entities.ExcelGenerator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExcelGeneratorRepository extends JpaRepository<ExcelGenerator, Long> {
}
