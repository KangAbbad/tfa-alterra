package com.alta.bootcamp.excelgeneratorapp.services;

import com.alta.bootcamp.excelgeneratorapp.dto.ExcelGeneratorDTO;
import com.alta.bootcamp.excelgeneratorapp.entities.ExcelGenerator;
import com.alta.bootcamp.excelgeneratorapp.repositories.ExcelGeneratorRepository;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ExcelGeneratorService implements IExcelGeneratorService {
  @Value("${excel.content-type}")
  private String fileType;

  @Autowired
  ModelMapper modelMapper;

  @Autowired
  ExcelGeneratorRepository excelGeneratorRepository;

  @Override
  public List<ExcelGeneratorDTO> upload(MultipartFile file) {
    if (!fileType.equals(file.getContentType())) {
      throw new RuntimeException("Format file tidak didukung");
    }
    List<ExcelGenerator> excelGenerators = convertExcelToEntity(file);
    List<ExcelGenerator> created = excelGeneratorRepository.saveAll(excelGenerators);
    return created.stream()
      .map(excelGenerator -> modelMapper.map(excelGenerator, ExcelGeneratorDTO.class))
      .collect(Collectors.toList());
  }

  private List<ExcelGenerator> convertExcelToEntity(MultipartFile file) {
    try (InputStream inputStream = file.getInputStream()) {
      Workbook workbook = new XSSFWorkbook(inputStream);
      String firstSheet = workbook.getSheetAt(0).getSheetName();
      Sheet sheet1 = workbook.getSheet(firstSheet);

      List<ExcelGenerator> excelGenerators = new ArrayList<>();

      Iterator<Row> it = sheet1.iterator();
      int indexRow = 0;

      while (it.hasNext()) {
        Row row = it.next();

        if (indexRow == 0) {
          indexRow++;
          continue;
        };

        ExcelGenerator excelGenerator = new ExcelGenerator();
        Iterator<Cell> colIt = row.iterator();
        int indexCol = 0;

        while (colIt.hasNext()) {
          Cell cell = colIt.next();

          switch (indexCol) {
            case 0 -> excelGenerator.setId(convertCellValueToLong(cell));
            case 1 -> excelGenerator.setName(cell.getStringCellValue());
            case 2 -> excelGenerator.setTicker(cell.getStringCellValue());
            case 3 -> excelGenerator.setCoinId(convertCellValueToLong(cell));
            case 4 -> excelGenerator.setCode(cell.getStringCellValue());
            case 5 -> excelGenerator.setExchange(cell.getStringCellValue());
            case 6 -> excelGenerator.setInvalid(convertCellValueToInt(cell));
            case 7 -> excelGenerator.setRecordTime(convertCellValueToLong(cell));
            case 8 -> excelGenerator.setUsd(convertCellValueToLong(cell));
            case 9 -> excelGenerator.setIdr(convertCellValueToLong(cell));
            case 10 -> excelGenerator.setHnst(convertCellValueToInt(cell));
            case 11 -> excelGenerator.setEth(convertCellValueToLong(cell));
            case 12 -> excelGenerator.setBtc(convertCellValueToLong(cell));
            case 13 -> excelGenerator.setCreatedAt(convertCellValueToDate(cell));
            case 14 -> excelGenerator.setUpdatedAt(convertCellValueToDate(cell));
          }

          indexCol++;
          excelGenerators.add(excelGenerator);
        }
      }

      return excelGenerators;
    } catch (IOException ioe) {
      ioe.printStackTrace();
    }

    return Collections.emptyList();
  }

  private Long convertCellValueToLong(Cell cell) {
    if (cell == null) return null;
    if (cell.getCellType().equals(CellType.NUMERIC)) {
      return (long) cell.getNumericCellValue();
    } else {
      if (Objects.equals(cell.getStringCellValue(), "")) return 0L;
      String cellString = cell.getStringCellValue();
      return Long.valueOf(cellString);
    }
  }

  private int convertCellValueToInt(Cell cell) {
    if (cell == null) return 0;
    if (cell.getCellType().equals(CellType.NUMERIC)) {
      return (int) cell.getNumericCellValue();
    } else {
      if (Objects.equals(cell.getStringCellValue(), "")) return 0;
      String cellString = cell.getStringCellValue();
      return Integer.parseInt(cellString);
    }
  }

  private Date convertCellValueToDate(Cell cell) {
    if (cell == null) return new Date();
    if (cell.getCellType().equals(CellType.NUMERIC)) {
      return cell.getDateCellValue();
    }
    return null;
  }
}
