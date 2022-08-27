package com.alta.bootcamp.laundryapp.services;

import com.alta.bootcamp.laundryapp.dto.UserRequestDTO;
import com.alta.bootcamp.laundryapp.dto.UserResponseDTO;

import java.io.Serializable;
import java.util.List;

public interface IUserService extends Serializable {
  UserResponseDTO createUser(UserRequestDTO request);
  List<UserResponseDTO> getAllUsers();
  UserResponseDTO getUser(Long id);
  UserResponseDTO updateUser(UserRequestDTO request, Long id);
  String deleteUser(Long id);
}
