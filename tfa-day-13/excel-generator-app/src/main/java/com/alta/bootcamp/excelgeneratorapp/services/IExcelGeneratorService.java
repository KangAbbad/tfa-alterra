package com.alta.bootcamp.excelgeneratorapp.services;

import com.alta.bootcamp.excelgeneratorapp.dto.ExcelGeneratorDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IExcelGeneratorService {
  List<ExcelGeneratorDTO> upload(MultipartFile file);
}
