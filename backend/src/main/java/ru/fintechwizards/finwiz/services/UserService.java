package ru.fintechwizards.finwiz.services;

import java.security.Principal;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fintechwizards.finwiz.exceptions.NotFoundException;
import ru.fintechwizards.finwiz.models.User;
import ru.fintechwizards.finwiz.repositories.UserCrudRepository;
import ru.fintechwizards.finwiz.repositories.UserJpaRepository;
import ru.fintechwizards.finwiz.responses.UserInfoResponse;

@Service
public class UserService {
  @Autowired
  private UserJpaRepository userJpaRepository;

  @Autowired
  private UserCrudRepository userCrudRepository;

  @Autowired
  private AccountService accountService;

  public void saveUser(User user) {
    userCrudRepository.save(user);
  }

  public UserInfoResponse getUserInfo(Principal principal) {
    if (principal == null) {
      throw new NotFoundException("User not found");
    }
    String username = principal.getName();
    Optional<User> user = userJpaRepository.findByUsername(username);
    if (user.isEmpty()) {
      throw new NotFoundException("User not found");
    }
    User userEntity = user.get();
    UserInfoResponse response = new UserInfoResponse(userEntity.getId(),userEntity.getUsername(),
        userEntity.isEnabled(), accountService.findAccountsByUserId(userEntity.getId()));
    return response;
  }
}
