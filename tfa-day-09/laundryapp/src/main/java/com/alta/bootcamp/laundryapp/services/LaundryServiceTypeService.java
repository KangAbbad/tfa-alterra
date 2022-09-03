package com.alta.bootcamp.laundryapp.services;

import com.alta.bootcamp.laundryapp.dto.LaundryServiceTypeRequestDTO;
import com.alta.bootcamp.laundryapp.dto.LaundryServiceTypeResponseDTO;
import com.alta.bootcamp.laundryapp.entities.LaundryServiceType;
import com.alta.bootcamp.laundryapp.exceptions.ResourceNotFoundException;
import com.alta.bootcamp.laundryapp.exceptions.ValidationErrorException;
import com.alta.bootcamp.laundryapp.repositories.LaundryServiceTypeRepository;
import lombok.SneakyThrows;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class LaundryServiceTypeService implements ILaundryServiceTypeService {
  @Autowired
  ModelMapper modelMapper;
  @Autowired
  LaundryServiceTypeRepository laundryServiceTypeRepository;

  @SneakyThrows
  @Override
  @Transactional
  public LaundryServiceTypeResponseDTO createLaundryServiceType(LaundryServiceTypeRequestDTO request) {
    validate(request);
    LaundryServiceType laundryServiceType = convertToEntity(request);
    LaundryServiceType createdLaundryServiceType = laundryServiceTypeRepository.save(laundryServiceType);
    return convertToDto(createdLaundryServiceType);
  }

  @Override
  public List<LaundryServiceTypeResponseDTO> getAllLaundryServiceTypes() {
    List<LaundryServiceType> laundryServiceTypes = laundryServiceTypeRepository.findAll();
    if (laundryServiceTypes.isEmpty()) return Collections.emptyList();
    return laundryServiceTypes.stream()
      .map(laundryServiceType -> modelMapper.map(laundryServiceType, LaundryServiceTypeResponseDTO.class))
            .collect(Collectors.toList());
  }

  @Override
  public LaundryServiceTypeResponseDTO getLaundryServiceType(Long id) {
    LaundryServiceType laundryServiceType = laundryServiceTypeRepository.getLaundryServiceTypeById(id);
    return convertToDto(laundryServiceType);
  }

  @Override
  public LaundryServiceTypeResponseDTO updateLaundryServiceType(LaundryServiceTypeRequestDTO request, Long id) {
    validate(request);
    Optional<LaundryServiceType> findLaundryServiceType = laundryServiceTypeRepository.findById(id);
    if (findLaundryServiceType.isPresent()) {
      LaundryServiceType tempLaundryServiceType = findLaundryServiceType.get();
      tempLaundryServiceType.setName(request.getName());
      tempLaundryServiceType.setDescription(request.getDescription());
      tempLaundryServiceType.setPrice(request.getPrice());
      LaundryServiceType convertToEntity = modelMapper.map(tempLaundryServiceType, LaundryServiceType.class);
      LaundryServiceType updatedLaundryServiceType = laundryServiceTypeRepository.save(convertToEntity);
      return convertToDto(updatedLaundryServiceType);
    } else {
      throw new ResourceNotFoundException("Laundry Service Type not found");
    }
  }

  public String deleteLaundryServiceType(Long id) {
    if (id == null) {
      throw new ValidationErrorException("ID cannot be empty");
    }

    Optional<LaundryServiceType> laundryServiceType = laundryServiceTypeRepository.findById(id);
    if (laundryServiceType.isPresent()) {
      laundryServiceTypeRepository.deleteById(id);
      return laundryServiceType.get().getName() + " successfully deleted";
    } else {
      return "Laundry Service Type not found";
    }
  }

  private void validate(LaundryServiceTypeRequestDTO request) {
    if (request == null) {
      throw new ValidationErrorException("Body request cannot be empty");
    }

    if (StringUtils.isEmpty(request.getName())) {
      throw new ValidationErrorException("Name cannot be empty");
    }

    if (StringUtils.isEmpty(request.getDescription())) {
      throw new ValidationErrorException("Description cannot be empty");
    }
  }

  private LaundryServiceType convertToEntity(LaundryServiceTypeRequestDTO request) {
    return modelMapper.map(request, LaundryServiceType.class);
  }

  private LaundryServiceTypeResponseDTO convertToDto(LaundryServiceType laundryServiceType) {
    return modelMapper.map(laundryServiceType, LaundryServiceTypeResponseDTO.class);
  }
}
