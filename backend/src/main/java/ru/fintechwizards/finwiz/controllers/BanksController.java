package ru.fintechwizards.finwiz.controllers;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ru.fintechwizards.finwiz.exceptions.AlreadyExistsException;
import ru.fintechwizards.finwiz.exceptions.NotFoundException;
import ru.fintechwizards.finwiz.models.Bank;
import ru.fintechwizards.finwiz.requests.BankRequest;
import ru.fintechwizards.finwiz.responses.BankResponse;
import ru.fintechwizards.finwiz.services.BanksService;

@RestController
@CrossOrigin
@Tag(name = "Контроллер банков",description = "Методы позволяют управлять банками")
public class BanksController {

  private final BanksService banksService;

  public BanksController(BanksService banksService) {
    this.banksService = banksService;
  }

  @PostMapping("/banks/create")
  @Operation(
          summary = "Добавление банка",
          description = "Позволяет добавить банк в бд"
  )
  public ResponseEntity<Object> createNewBank(@RequestBody BankRequest req) {
    try {
      return ResponseEntity.ok(banksService.createBank(req));
    } catch (AlreadyExistsException e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
    }
  }

  @GetMapping("/banks/all")
  @Operation(
          summary = "Получение всех банков",
          description = "Позволяет получить все зарегистрированные банки"
  )
  public ResponseEntity<List<Bank>> listAllBanks() {
    return new ResponseEntity<>(banksService.getAllBanks(), HttpStatus.OK);
  }

  @GetMapping("/banks/get/{id}")
  @Operation(
          summary = "Получение банка",
          description = "Позволяет получить банк по его id"
  )
  public ResponseEntity<Object> getBankById(@PathVariable("id") Long id) {
    try {
      BankResponse bankResponse = banksService.getBankById(id);
      return ResponseEntity.ok(bankResponse);
    } catch (NotFoundException e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
  }
}
