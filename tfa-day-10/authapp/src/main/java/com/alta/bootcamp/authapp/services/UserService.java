package com.alta.bootcamp.authapp.services;

import com.alta.bootcamp.authapp.dto.UserRequestDTO;
import com.alta.bootcamp.authapp.dto.UserResponseDTO;
import com.alta.bootcamp.authapp.entities.User;
import com.alta.bootcamp.authapp.exceptions.ValidationErrorException;
import com.alta.bootcamp.authapp.repositories.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {
  @Autowired
  UserRepository userRepository;
  @Autowired
  ModelMapper modelMapper;

  @Override
  public UserResponseDTO createUser(UserRequestDTO request) {
    validate(request);
    User user = convertToEntity(request);
    User createdUser = userRepository.save(user);
    return convertToDto(createdUser);
  }

  @Override
  public List<UserResponseDTO> getAllUsers() {
    List<User> users = userRepository.findAll();
    return users.stream()
      .map(user -> modelMapper.map(user, UserResponseDTO.class))
      .collect(Collectors.toList());
  }

  @Override
  public UserResponseDTO getUser(Long id) {
    Optional<User> optUser = userRepository.getUserById(id);
    if (optUser.isPresent()) {
      return convertToDto(optUser.get());
    } else {
      throw new ValidationErrorException("User not found");
    }
  }

  @Override
  public UserResponseDTO updateUser(UserRequestDTO request, Long id) {
    validate(request);
    Optional<User> optUser = userRepository.findById(id);
    if (optUser.isPresent()) {
      User tempUser = optUser.get();
      tempUser.setUsername(request.getUsername());
      tempUser.setPhone(request.getPhone());
      tempUser.setPassword(request.getPassword());

      User convertToEntity = modelMapper.map(tempUser, User.class);
      User updatedUser = userRepository.save(convertToEntity);
      return convertToDto(updatedUser);
    } else {
      throw new ValidationErrorException("User not found");
    }
  }

  @Override
  public String deleteUser(Long id) {
    if (id == null) throw new ValidationErrorException("ID cannot be empty");
    Optional<User> optUser = userRepository.findById(id);
    if (optUser.isPresent()) {
      User tempUser = optUser.get();
      userRepository.deleteById(id);
      return tempUser.getUsername() + " successfully deleted";
    } else {
      throw new ValidationErrorException("User not found");
    }
  }

  private void validate(UserRequestDTO request) {
    if (request == null) {
      throw new ValidationErrorException("Body request cannot be empty");
    }

    if (StringUtils.isEmpty(request.getUsername())) {
      throw new ValidationErrorException("Username cannot be empty");
    }

    if (StringUtils.isEmpty(request.getPhone())) {
      throw new ValidationErrorException("Phone number cannot be empty");
    }

    if (StringUtils.isEmpty(request.getPassword())) {
      throw new ValidationErrorException("Password cannot be empty");
    }
  }

  private User convertToEntity(UserRequestDTO request) {
    return modelMapper.map(request, User.class);
  }

  private UserResponseDTO convertToDto(User user) {
    return modelMapper.map(user, UserResponseDTO.class);
  }
}
