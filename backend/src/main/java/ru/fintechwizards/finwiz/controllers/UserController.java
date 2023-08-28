package ru.fintechwizards.finwiz.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import java.security.Principal;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.fintechwizards.finwiz.models.User;
import ru.fintechwizards.finwiz.responses.UserInfoResponse;
import ru.fintechwizards.finwiz.services.UserService;

@RestController
@CrossOrigin
public class UserController {
  @Autowired
  private UserService userService;
  @Autowired
  private ObjectMapper objectMapper;
  @GetMapping("/user")
  public ResponseEntity<String> getUserInfo(Principal principal) {
    try {
      UserInfoResponse user = userService.getUserInfo(principal);
      return ResponseEntity.ok(objectMapper.writeValueAsString(user));
    } catch (Exception e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

  }
}
