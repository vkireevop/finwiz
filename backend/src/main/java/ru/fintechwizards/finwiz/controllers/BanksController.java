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
import ru.fintechwizards.finwiz.models.Bank;
import ru.fintechwizards.finwiz.repositories.BankJpaRepository;
import ru.fintechwizards.finwiz.repositories.BankRepository;
import ru.fintechwizards.finwiz.requests.BankRequest;
import ru.fintechwizards.finwiz.responses.BankResponse;

@RestController
@CrossOrigin
public class BanksController {
  @Autowired
  private BankRepository bankRepository;
  @Autowired
  private BankJpaRepository bankJpaRepository;
  @PostMapping("/banks/create")
  public ResponseEntity<String> createNewBank(@RequestBody BankRequest req) {
    String name = req.getName();
    String address = req.getAddress();
    if (bankJpaRepository.findByName(name).isPresent()) {
      return new ResponseEntity<>("Bank already exists", HttpStatus.SERVICE_UNAVAILABLE);
    }
    bankRepository.save(new Bank(name, address));
    return ResponseEntity.ok("Success");
  }

  @GetMapping("/banks/all")
  public ResponseEntity<List<Bank>> listAllBanks() {
    return new ResponseEntity<>(bankRepository.findAll(), HttpStatus.OK);
  }

  @GetMapping("/banks/get/{id}")
  public ResponseEntity<Object> getBankById(@PathVariable("id") Long id) {
    Optional<Bank> bank = bankRepository.findById(id);
    if (bank.isPresent()) {
      Bank bankEntity = bank.get();
      return new ResponseEntity<>(new BankResponse(bankEntity.getBankId(),
          bankEntity.getName(),
          bankEntity.getAddress()), HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @GetMapping("/banks/get/{name}")
  public ResponseEntity<Object> getBankByName(@PathVariable("name") String name) {
    Optional<Bank> bank = bankJpaRepository.findByName(name);
    if (bank.isPresent()) {
      Bank bankEntity = bank.get();
      return new ResponseEntity<>(new BankResponse(bankEntity.getBankId(),
          bankEntity.getName(),
          bankEntity.getAddress()), HttpStatus.OK);
    }
    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
}
