package com.alta.bootcamp.laundryapp.unittest;

import com.alta.bootcamp.laundryapp.dto.UserRequestDTO;
import com.alta.bootcamp.laundryapp.dto.UserResponseDTO;
import com.alta.bootcamp.laundryapp.entities.User;
import com.alta.bootcamp.laundryapp.exceptions.DataAlreadyExistException;
import com.alta.bootcamp.laundryapp.exceptions.ValidationErrorException;
import com.alta.bootcamp.laundryapp.repositories.UserRepository;
import com.alta.bootcamp.laundryapp.services.UserService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
  @Mock
  UserRepository userRepository;

  @InjectMocks
  UserService serviceUnderTest = spy(new UserService());

  ModelMapper modelMapper = spy(new ModelMapper());

  @BeforeEach
  void setup() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void givenValidRequest_when_createNewUser_then_userShouldBeCreated() {
    UserRequestDTO request = new UserRequestDTO();
    request.setName("Mr D");
    request.setEmail("mrd@email.com");
    request.setPhone("082184743978");

    User user = modelMapper.map(request, User.class);
    user.setId(3L);

    when(userRepository.save(any(User.class))).thenReturn(user);

    UserResponseDTO response = serviceUnderTest.createUser(request);
    assertThat(response.getId()).isNotNull();
    assertThat(response.getName()).isEqualTo(request.getName());
    assertThat(response.getEmail()).isEqualTo(request.getEmail());
    assertThat(response.getPhone()).isEqualTo(request.getPhone());
  }

  @Test(expected = ValidationErrorException.class)
  public void givenNullRequest_when_createNewUser_then_shouldThrowException() {
    serviceUnderTest.createUser(null);
  }

  @Test(expected = ValidationErrorException.class)
  public void givenEmptyNameRequest_when_createNewUser_then_shouldThrowException() {
    UserRequestDTO request = new UserRequestDTO();
    request.setName("");
    request.setEmail("mrd@email.com");
    request.setPhone("082184743978");

    User user = modelMapper.map(request, User.class);
    user.setId(1L);

    serviceUnderTest.createUser(request);
  }

  @Test(expected = ValidationErrorException.class)
  public void givenEmptyEmailRequest_when_createNewUser_then_shouldThrowException() {
    UserRequestDTO request = new UserRequestDTO();
    request.setName("Mr D");
    request.setEmail("");
    request.setPhone("082184743978");

    User user = modelMapper.map(request, User.class);
    user.setId(1L);

    serviceUnderTest.createUser(request);
  }

  @Test(expected = ValidationErrorException.class)
  public void givenEmptyPhoneRequest_when_createNewUser_then_shouldThrowException() {
    UserRequestDTO request = new UserRequestDTO();
    request.setName("Mr D");
    request.setEmail("mrd@email.com");
    request.setPhone("");

    User user = modelMapper.map(request, User.class);
    user.setId(1L);

    serviceUnderTest.createUser(request);
  }

  @Test(expected = DataAlreadyExistException.class)
  public void givenValidRequestAndUserAlreadyExist_when_createNewUser_then_shouldThrowException() {
    UserRequestDTO request = new UserRequestDTO();
    request.setName("Mr D");
    request.setEmail("mrd@email.com");
    request.setPhone("081234567898");

    User user = modelMapper.map(request, User.class);
    user.setId(3L);

    when(userRepository.findByPhone(anyString())).thenReturn(Optional.of(user));

    serviceUnderTest.createUser(request);
  }
}
