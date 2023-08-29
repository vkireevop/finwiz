package ru.fintechwizards.finwiz.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
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
@Tag(name = "Контроллер валюты",description = "Методы позволяют получать курс валют")
public class CurrencyController {
  @Autowired
  private ObjectMapper objectMapper;

  @GetMapping("exchange/{code}")
  @Operation(
          summary = "Получение курса",
          description = "Позволяет получить курс выбранной валюты к рублю"
  )
  public ResponseEntity<Object> getRate(@PathVariable("code") String code) throws IOException {
    try {
      float result = CurrencyService.getExchangeRate(code);
      return ResponseEntity.ok(result);
    } catch (NotFoundException e) {
      return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
  }

  @GetMapping("exchange/rates/all")
  public ResponseEntity<Object> getAllRates() throws IOException {
    String json = objectMapper.writeValueAsString(CurrencyService.getAllRates());
    return ResponseEntity.ok(json);
  }
}
