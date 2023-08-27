package ru.fintechwizards.finwiz.RestControllers;

import java.io.IOException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ru.fintechwizards.finwiz.Services.CurrencyService;

@RestController
@CrossOrigin
public class CurrencyController {
  @GetMapping("exchange/{code}")
  public ResponseEntity<?> getRate(@PathVariable("code") String code) throws IOException {
    return ResponseEntity.ok(CurrencyService.getExchangeRate(code));
  }
}
