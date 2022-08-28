package com.alta.bootcamp.authapp.services;

import com.alta.bootcamp.authapp.entities.User;
import com.alta.bootcamp.authapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService {
  @Autowired
  UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String usernameOrPhone) throws UsernameNotFoundException {
    User user = userRepository.findByUsernameOrPhone(usernameOrPhone, usernameOrPhone)
      .orElseThrow(() ->
        new UsernameNotFoundException("User not found with username or email : " + usernameOrPhone)
      );
    return UserPrincipal.create(user);
  }

  @Transactional
  public UserDetails loadUserById(Long id) {
    User user = userRepository.findById(id).orElseThrow(
      () -> new UsernameNotFoundException("User not found with id : " + id)
    );

    return UserPrincipal.create(user);
  }
}
