package ru.fintechwizards.finwiz.controllers;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.fintechwizards.finwiz.services.CurrencyService;

@RestController
@CrossOrigin
public class TestController {
  @Autowired
  private CurrencyService currencyService;

  @GetMapping("/")
  public ResponseEntity<String> root() {
    return ResponseEntity.ok("Hello world!");
  }

  @GetMapping("/currency/")
  public ResponseEntity<Float> currency() throws IOException {
    return ResponseEntity.ok(CurrencyService.getExchangeRate(""));
  }
}
