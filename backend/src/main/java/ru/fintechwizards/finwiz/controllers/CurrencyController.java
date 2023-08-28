package ru.fintechwizards.finwiz.controllers;

import java.io.IOException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.fintechwizards.finwiz.exceptions.NotFoundException;
import ru.fintechwizards.finwiz.services.CurrencyService;

@RestController
@CrossOrigin
public class CurrencyController {
  @GetMapping("exchange/{code}")
  public ResponseEntity<Object> getRate(@PathVariable("code") String code) throws IOException {
    try {
      float result = CurrencyService.getExchangeRate(code);
      return ResponseEntity.ok(result);
    } catch (NotFoundException e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
  }
}
