package ru.fintechwizards.finwiz.controllers;

import java.math.BigDecimal;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.fintechwizards.finwiz.models.Account;
import ru.fintechwizards.finwiz.models.Bank;
import ru.fintechwizards.finwiz.models.User;
import ru.fintechwizards.finwiz.repositories.UserJpaRepository;
import ru.fintechwizards.finwiz.requests.AuthRequest;
import ru.fintechwizards.finwiz.responses.AuthResponse;
import ru.fintechwizards.finwiz.responses.BankResponse;
import ru.fintechwizards.finwiz.security.TokenService;
import ru.fintechwizards.finwiz.services.AccountService;
import ru.fintechwizards.finwiz.services.BanksService;
import ru.fintechwizards.finwiz.services.MyUserDetailsService;
import ru.fintechwizards.finwiz.services.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
public class AuthController {

  @Autowired
  private UserJpaRepository userRepository;
  @Autowired
  private UserService userService;
  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  @Autowired
  private TokenService tokenService;

  @Autowired
  private MyUserDetailsService myUserDetailsService;

  @Autowired
  private AccountService accountService;

  @Autowired
  private BanksService banksService;

  @PostMapping("/auth/login")
  public ResponseEntity<AuthResponse> auth(@RequestBody AuthRequest authRequest) {
    String username = authRequest.getUsername();
    String password = authRequest.getPassword();
    try {
      authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(username, password));
    } catch (BadCredentialsException e) {
      return new ResponseEntity<>(new AuthResponse("Wrong password or username", null),
          HttpStatus.UNAUTHORIZED);
    }
    User user = (User) myUserDetailsService.loadUserByUsername(username);
    String accessToken = tokenService.generateAccessToken(user);
    return new ResponseEntity<>(new AuthResponse("Success", accessToken), HttpStatus.OK);
  }

  @PostMapping("auth/signup")
  public ResponseEntity<Object> signup(@RequestBody AuthRequest authRequest) {
    String username = authRequest.getUsername();
    String password = authRequest.getPassword();

    if (userRepository.findByUsername(username).isPresent()) {
      return new ResponseEntity<>(
          new AuthResponse("User exists", null), HttpStatus.UNAUTHORIZED
      );
    }

    User user = new User(username, bCryptPasswordEncoder.encode(password));
    String accessToken = tokenService.generateAccessToken(user);

    userService.saveUser(user);
    Optional<Bank> bank = banksService.findById(Long.valueOf(1));
    if (bank.isPresent()) {
      Account account = new Account(user, bank.get(), "RUB",
          BigDecimal.valueOf(0));
      accountService.createAccount(account);
      return new ResponseEntity<>(new AuthResponse("Success", accessToken), HttpStatus.OK);
    } else {
      return new ResponseEntity<>("Account not found", HttpStatus.NOT_FOUND);
    }

  }


}

