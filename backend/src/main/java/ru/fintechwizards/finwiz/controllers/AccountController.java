package ru.fintechwizards.finwiz.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.fintechwizards.finwiz.exceptions.NotFoundException;
import ru.fintechwizards.finwiz.requests.DepositMoneyRequest;
import ru.fintechwizards.finwiz.services.AccountService;

@RestController
@CrossOrigin
public class AccountController {
  @Autowired
  private AccountService accountService;

  @Autowired
  private ObjectMapper objectMapper;

  @GetMapping("/account/all")
  public ResponseEntity<String> getAllAccounts() throws JsonProcessingException {
    String json = objectMapper.writeValueAsString(accountService.getAllAccounts());
    return ResponseEntity.ok(json);
  }

  // TODO
  @PostMapping("/account/create")
  public ResponseEntity<String> createAccount() {
      return ResponseEntity.ok("");
  }
  @PostMapping("/account/deposit")
  public ResponseEntity<?> addMoney(@RequestBody DepositMoneyRequest request) {
    try {
      return ResponseEntity.ok(accountService.addMoney(request));
    } catch (NotFoundException e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
  }
}
