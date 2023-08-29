package ru.fintechwizards.finwiz.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ru.fintechwizards.finwiz.exceptions.NotFoundException;
import ru.fintechwizards.finwiz.requests.AccountRequest;
import ru.fintechwizards.finwiz.requests.DepositMoneyRequest;
import ru.fintechwizards.finwiz.services.AccountService;

@RestController
@CrossOrigin
@Tag(name = "Контроллер личного счёта",description = "Методы позволяют управлять и получать данные о счетах пользователя")
public class AccountController {
  @Autowired
  private AccountService accountService;

  @Autowired
  private ObjectMapper objectMapper;

  @GetMapping("/account/all")
  @Operation(
          summary = "Получение всех счетов из бд",
          description = "Позволяет получить все зарегистрированные счета"
  )
  public ResponseEntity<String> getAllAccounts() throws JsonProcessingException {
    String json = objectMapper.writeValueAsString(accountService.getAllAccounts());
    return ResponseEntity.ok(json);
  }

  @PostMapping("/account/create")
  @Operation(
          summary = "Регистрация счёта",
          description = "Позволяет зарегистрировать счёт"
  )
  public ResponseEntity<String> createAccount(@RequestBody AccountRequest request) {
    accountService.createAccount(request);
    return ResponseEntity.ok("OK");
  }
  @PostMapping("/account/deposit")
  @Operation(
          summary = "Депозит",
          description = "Позволяет добавить баланс на счёт"
  )
  public ResponseEntity<?> addMoney(@RequestBody DepositMoneyRequest request) {
    try {
      return ResponseEntity.ok(accountService.addMoney(request));
    } catch (NotFoundException e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
  }
}
