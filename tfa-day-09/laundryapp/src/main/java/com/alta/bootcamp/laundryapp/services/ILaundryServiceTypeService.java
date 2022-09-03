package com.alta.bootcamp.laundryapp.services;

import com.alta.bootcamp.laundryapp.dto.LaundryServiceTypeRequestDTO;
import com.alta.bootcamp.laundryapp.dto.LaundryServiceTypeResponseDTO;

import java.io.Serializable;
import java.util.List;


public interface ILaundryServiceTypeService extends Serializable {
  LaundryServiceTypeResponseDTO createLaundryServiceType(LaundryServiceTypeRequestDTO request);
  List<LaundryServiceTypeResponseDTO> getAllLaundryServiceTypes();
  LaundryServiceTypeResponseDTO getLaundryServiceType(Long id);
  LaundryServiceTypeResponseDTO updateLaundryServiceType(LaundryServiceTypeRequestDTO request, Long id);
  String deleteLaundryServiceType(Long id);
}
