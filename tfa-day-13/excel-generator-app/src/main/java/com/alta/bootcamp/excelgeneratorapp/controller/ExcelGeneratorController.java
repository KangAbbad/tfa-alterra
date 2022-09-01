package com.alta.bootcamp.excelgeneratorapp.controller;

import com.alta.bootcamp.excelgeneratorapp.dto.ExcelGeneratorDTO;
import com.alta.bootcamp.excelgeneratorapp.services.IExcelGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/excel-generator")
public class ExcelGeneratorController {
  @Autowired
  IExcelGeneratorService excelGeneratorService;

  @PostMapping("/upload")
  public ResponseEntity<List<ExcelGeneratorDTO>> upload(@RequestParam("file") MultipartFile file) {
    List<ExcelGeneratorDTO> response = excelGeneratorService.upload(file);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
