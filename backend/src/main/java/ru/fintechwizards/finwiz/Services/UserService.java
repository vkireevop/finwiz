package ru.fintechwizards.finwiz.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fintechwizards.finwiz.Models.User;
import ru.fintechwizards.finwiz.Repositories.UserCrudRepository;
import ru.fintechwizards.finwiz.Repositories.UserJpaRepository;

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
