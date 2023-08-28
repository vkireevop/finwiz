package ru.fintechwizards.finwiz.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;
import ru.fintechwizards.finwiz.models.User;
import ru.fintechwizards.finwiz.repositories.UserJpaRepository;

public class MyUserDetailsService implements UserDetailsService {

  @Autowired
  UserJpaRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Optional<User> user = userRepository.findByUsername(username);
    if (user.isEmpty()) {
      throw new UsernameNotFoundException("User not found");
    }
    return user.get();
  }

}

