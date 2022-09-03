package com.alta.bootcamp.queueloggingapp.services;

import com.alta.bootcamp.queueloggingapp.dto.UserRequestDTO;
import com.alta.bootcamp.queueloggingapp.dto.UserResponseDTO;
import com.alta.bootcamp.queueloggingapp.entities.User;
import com.alta.bootcamp.queueloggingapp.exceptions.DataAlreadyExistException;
import com.alta.bootcamp.queueloggingapp.exceptions.ResourceNotFoundException;
import com.alta.bootcamp.queueloggingapp.exceptions.ValidationErrorException;
import com.alta.bootcamp.queueloggingapp.repositories.UserRepository;
import com.alta.bootcamp.queueloggingapp.utils.ValidateUtils;
import lombok.SneakyThrows;
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
  @Autowired
  ValidateUtils validateUtils;

  @SneakyThrows
  @Override
  @Transactional
  public UserResponseDTO createUser(UserRequestDTO request) {
    validateUtils.userRequest(request);

    User user = convertToEntity(request);
    Optional<User> duplicateUsername = userRepository.findByEmail(request.getEmail());
    Optional<User> duplicateEmail = userRepository.findByEmail(request.getEmail());
    if (duplicateUsername.isPresent() || duplicateEmail.isPresent()) {
      throw new DataAlreadyExistException("Username / Email is already exists");
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
    validateUtils.userRequest(request);
    Optional<User> findUser = userRepository.findById(id);
    if (findUser.isPresent()) {
      User tempUser = findUser.get();
      tempUser.setUsername(request.getUsername());
      tempUser.setEmail(request.getEmail());
      tempUser.setPassword(request.getPassword());
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
      return findUser.get().getUsername() + " successfully deleted";
    } else {
      return "USER ID not found";
    }
  }

  private User convertToEntity(UserRequestDTO request) {
    return modelMapper.map(request, User.class);
  }

  private UserResponseDTO convertToDto(User user) {
    return modelMapper.map(user, UserResponseDTO.class);
  }
}
