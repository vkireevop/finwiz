package ru.fintechwizards.finwiz.exceptions;

public class CurrencyNotFoundException extends RuntimeException {
  public CurrencyNotFoundException() {
    super("Currency Not Found");
  }
}
