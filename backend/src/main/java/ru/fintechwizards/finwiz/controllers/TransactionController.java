package ru.fintechwizards.finwiz.controllers;

import java.io.IOException;
import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ru.fintechwizards.finwiz.exceptions.NotEnoughException;
import ru.fintechwizards.finwiz.models.Transaction;
import ru.fintechwizards.finwiz.requests.TransactionRequest;
import ru.fintechwizards.finwiz.services.TransactionService;

@RestController
@CrossOrigin
@Tag(name = "Контроллер транзакций",description = "Методы позволяют управлять транзакциями")
public class TransactionController {
  private final TransactionService transactionService;

  public TransactionController(TransactionService transactionService) {
    this.transactionService = transactionService;
  }

  @PostMapping("/transaction/make")
  @Operation(
          summary = "Создание транзакции",
          description = "Позволяет выполнить перевод с одного счёта на другой"
  )
  public ResponseEntity<?> makeTransaction(@RequestBody TransactionRequest transactionRequest)
      throws IOException {
    try {
      transactionService.makeTransaction(transactionRequest);
      return ResponseEntity.ok("Success");
    } catch (NotEnoughException e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  @GetMapping("/transaction/all")
  @Operation(
          summary = "Все транзакции аккаунта",
          description = "Позволяет получить все транзакции счёта"
  )
  public ResponseEntity<List<Transaction>> allTransactionForUser(@RequestBody Long id)
  {
    return ResponseEntity.ok(transactionService.findAllSenderId(id));
  }
}
