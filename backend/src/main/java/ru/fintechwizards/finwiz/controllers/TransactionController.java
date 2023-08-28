package ru.fintechwizards.finwiz.controllers;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.fintechwizards.finwiz.exceptions.NotEnoughException;
import ru.fintechwizards.finwiz.requests.TransactionRequest;
import ru.fintechwizards.finwiz.services.TransactionService;

@RestController
@CrossOrigin
public class TransactionController {
  @Autowired
  private TransactionService transactionService;
  @PostMapping("/transaction/make")
  public ResponseEntity<?> makeTransaction(@RequestBody TransactionRequest transactionRequest)
      throws IOException {
    try {
      transactionService.makeTransaction(transactionRequest);
      return ResponseEntity.ok("Success");
    } catch (NotEnoughException e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }
}
