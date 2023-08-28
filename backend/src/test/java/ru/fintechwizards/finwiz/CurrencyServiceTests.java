package ru.fintechwizards.finwiz;

import java.io.IOException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.fintechwizards.finwiz.exceptions.CurrencyNotFoundException;
import ru.fintechwizards.finwiz.services.CurrencyService;

public class CurrencyServiceTests {
  @Test
  public void testCurrencyThatDontExists() throws IOException {
    Assertions.assertThrows(CurrencyNotFoundException.class, () -> {
      float rate = CurrencyService.getExchangeRate("ABC");
    });
  }
}
