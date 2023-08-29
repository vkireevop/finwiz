package ru.fintechwizards.finwiz.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import java.security.Principal;
import java.util.Optional;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Контроллер пользователя",description = "Методы позволяют управлять данными пользователя")
public class UserController {
  private final UserService userService;
  private final ObjectMapper objectMapper;

  public UserController(UserService userService, ObjectMapper objectMapper) {
    this.userService = userService;
    this.objectMapper = objectMapper;
  }

  @GetMapping("/user")
  @Operation(
          summary = "Данные пользователя",
          description = "Позволяет получить все данные о пользователе"
  )
  public ResponseEntity<String> getUserInfo(Principal principal) {
    try {
      UserInfoResponse user = userService.getUserInfo(principal);
      return ResponseEntity.ok(objectMapper.writeValueAsString(user));
    } catch (Exception e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

  }
}
