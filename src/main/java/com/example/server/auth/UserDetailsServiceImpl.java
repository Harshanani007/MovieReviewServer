package com.example.server.auth;

import com.example.server.models.User;
import com.example.server.models.UserRepository;
import com.example.server.models.AdminRepository;
import java.util.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private AdminRepository adminRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    User user = userRepository.findByUserName(username).get(0);

    List<GrantedAuthority> authorities = new ArrayList<>();

    if (isAdmin(user.getUserName())) {
      authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
    } else {

      authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
    }

    CustomUserDetails userDetails = new CustomUserDetails(user.userName, user.passwordHash, authorities);

    return userDetails;
  }

  private boolean isAdmin(String username) {
    return adminRepository.existsByAdminName(username);
  }
}