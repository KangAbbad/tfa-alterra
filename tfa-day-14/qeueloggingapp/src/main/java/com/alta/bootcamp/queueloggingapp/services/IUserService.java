package com.alta.bootcamp.queueloggingapp.services;

import com.alta.bootcamp.queueloggingapp.dto.UserRequestDTO;
import com.alta.bootcamp.queueloggingapp.dto.UserResponseDTO;

import java.io.Serializable;
import java.util.List;

public interface IUserService extends Serializable {
  UserResponseDTO createUser(UserRequestDTO request);
  List<UserResponseDTO> getAllUsers();
  UserResponseDTO getUser(Long id);
  UserResponseDTO updateUser(UserRequestDTO request, Long id);
  String deleteUser(Long id);
}
