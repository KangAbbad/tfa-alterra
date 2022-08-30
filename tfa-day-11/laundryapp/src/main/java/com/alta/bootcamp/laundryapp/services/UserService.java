package com.alta.bootcamp.laundryapp.services;

import com.alta.bootcamp.laundryapp.dto.UserRequestDTO;
import com.alta.bootcamp.laundryapp.dto.UserResponseDTO;
import com.alta.bootcamp.laundryapp.entities.User;
import com.alta.bootcamp.laundryapp.exceptions.DataAlreadyExistException;
import com.alta.bootcamp.laundryapp.exceptions.ResourceNotFoundException;
import com.alta.bootcamp.laundryapp.exceptions.ValidationErrorException;
import com.alta.bootcamp.laundryapp.repositories.UserRepository;
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
public class UserService implements IUserService {

  @Autowired
  ModelMapper modelMapper;
  @Autowired
  UserRepository userRepository;

  @SneakyThrows
  @Override
  @Transactional
  public UserResponseDTO createUser(UserRequestDTO request) {
    validate(request);
    User user = convertToEntity(request);
    Optional<User> userOptional = userRepository.findByPhone(request.getPhone());
    if (userOptional.isPresent()) {
      throw new DataAlreadyExistException("Data with Key (phone) = (" + request.getPhone() + ") is already exists.");
    }
    User createdUser = userRepository.save(user);
    return convertToDto(createdUser);
  }

  @Override
  public List<UserResponseDTO> getAllUsers() {
    List<User> users = userRepository.findAll();
    if (users.isEmpty()) return Collections.emptyList();
    return users.stream()
      .map(user -> modelMapper.map(user, UserResponseDTO.class))
      .collect(Collectors.toList());
  }

  @Override
  public UserResponseDTO getUser(Long id) {
    User user = userRepository.getUserById(id);
    return convertToDto(user);
  }

  @Override
  public UserResponseDTO updateUser(UserRequestDTO request, Long id) {
    validate(request);
    Optional<User> findUser = userRepository.findById(id);
    if (findUser.isPresent()) {
      User tempUser = findUser.get();
      tempUser.setName(request.getName());
      tempUser.setEmail(request.getEmail());
      tempUser.setPhone(request.getPhone());
      User convertToEntity = modelMapper.map(tempUser, User.class);
      User updatedUser = userRepository.save(convertToEntity);
      return convertToDto(updatedUser);
    } else {
      throw new ResourceNotFoundException("User not found");
    }
  }

  @Override
  public String deleteUser(Long id) {
    if (id == null) {
      throw new ValidationErrorException("ID cannot be empty");
    }

    Optional<User> findUser = userRepository.findById(id);
    if (findUser.isPresent()) {
      userRepository.deleteById(id);
      return findUser.get().getName() + " successfully deleted";
    } else {
      return "USER ID not found";
    }
  }

  private void validate(UserRequestDTO request) {
    if (request == null) {
      throw new ValidationErrorException("Body request cannot be empty");
    }

    if (StringUtils.isEmpty(request.getName())) {
      throw new ValidationErrorException("Name cannot be empty");
    }

    if (StringUtils.isEmpty(request.getEmail())) {
      throw new ValidationErrorException("Email cannot be empty");
    }

    if (StringUtils.isEmpty(request.getPhone())) {
      throw new ValidationErrorException("Phone Number cannot be empty");
    }
  }

  private User convertToEntity(UserRequestDTO request) {
    return modelMapper.map(request, User.class);
  }

  private UserResponseDTO convertToDto(User user) {
    return modelMapper.map(user, UserResponseDTO.class);
  }
}
