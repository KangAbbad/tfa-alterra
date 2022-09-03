package com.alta.bootcamp.laundryapp.controller;

import com.alta.bootcamp.laundryapp.dto.LaundryServiceTypeRequestDTO;
import com.alta.bootcamp.laundryapp.dto.LaundryServiceTypeResponseDTO;
import com.alta.bootcamp.laundryapp.entities.LaundryServiceType;
import com.alta.bootcamp.laundryapp.services.ILaundryServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/laundry-services")
public class LaundryServiceTypeController {
  @Autowired
  ILaundryServiceTypeService laundryServiceTypeService;

  @PostMapping
  public ResponseEntity<LaundryServiceTypeResponseDTO> createLaundryServiceType(@RequestBody LaundryServiceTypeRequestDTO request) {
    LaundryServiceTypeResponseDTO response = laundryServiceTypeService.createLaundryServiceType(request);
    return new ResponseEntity<>(response, HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<LaundryServiceTypeResponseDTO>> getAllLaundryServiceTypes() {
    List<LaundryServiceTypeResponseDTO> response = laundryServiceTypeService.getAllLaundryServiceTypes();
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @GetMapping("/{id}")
  public ResponseEntity<LaundryServiceTypeResponseDTO> getLaundryServiceType(@PathVariable("id") Long id) {
    LaundryServiceTypeResponseDTO response = laundryServiceTypeService.getLaundryServiceType(id);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @PutMapping("/{id}")
  public ResponseEntity<LaundryServiceTypeResponseDTO> updateLaundryServiceType(@RequestBody LaundryServiceTypeRequestDTO request, @PathVariable("id") Long id) {
    LaundryServiceTypeResponseDTO response = laundryServiceTypeService.updateLaundryServiceType(request, id);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteLaundryServiceType(@PathVariable("id") Long id) {
    String response = laundryServiceTypeService.deleteLaundryServiceType(id);
    return new ResponseEntity<>(response, HttpStatus.OK);
  }
}
