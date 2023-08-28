package ru.fintechwizards.finwiz.controllers;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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
import ru.fintechwizards.finwiz.repositories.BankJpaRepository;
import ru.fintechwizards.finwiz.repositories.BankRepository;
import ru.fintechwizards.finwiz.requests.BankRequest;
import ru.fintechwizards.finwiz.responses.BankResponse;
import ru.fintechwizards.finwiz.services.BanksService;

@RestController
@CrossOrigin
public class BanksController {

  @Autowired
  private BanksService banksService;

  @PostMapping("/banks/create")
  public ResponseEntity<Object> createNewBank(@RequestBody BankRequest req) {
    try {
      return ResponseEntity.ok(banksService.createBank(req));
    } catch (AlreadyExistsException e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
    }
  }

  @GetMapping("/banks/all")
  public ResponseEntity<List<Bank>> listAllBanks() {
    return new ResponseEntity<>(banksService.getAllBanks(), HttpStatus.OK);
  }

  @GetMapping("/banks/get/{id}")
  public ResponseEntity<Object> getBankById(@PathVariable("id") Long id) {
    try {
      BankResponse bankResponse = banksService.getBankById(id);
      return ResponseEntity.ok(bankResponse);
    } catch (NotFoundException e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping("/banks/get/{name}")
  public ResponseEntity<Object> getBankByName(@PathVariable("name") String name) {
    try {
      BankResponse bankResponse = banksService.getBankByName(name);
      return ResponseEntity.ok(bankResponse);
    } catch (NotFoundException e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
  }
}
