package ru.fintechwizards.finwiz;

import java.io.IOException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.fintechwizards.finwiz.exceptions.NotFoundException;
import ru.fintechwizards.finwiz.services.CurrencyService;

public class CurrencyServiceTests {
  @Test
  public void testCurrencyThatDontExists() throws IOException {
    Assertions.assertThrows(NotFoundException.class, () -> {
      float rate = CurrencyService.getExchangeRate("ABC");
    });
  }
}
