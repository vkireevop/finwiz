package ru.fintechwizards.finwiz.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fintechwizards.finwiz.models.User;
import ru.fintechwizards.finwiz.repositories.UserCrudRepository;
import ru.fintechwizards.finwiz.repositories.UserJpaRepository;

@Service
public class UserService {
  @Autowired
  private UserJpaRepository userJpaRepository;

  @Autowired
  private UserCrudRepository userCrudRepository;

  public void saveUser(User user) {
    userCrudRepository.save(user);
  }
}
