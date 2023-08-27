package ru.fintechwizards.finwiz.RestControllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TestController {
  public ResponseEntity<String> root() {
    return ResponseEntity.ok("Hello world!");
  }
}
