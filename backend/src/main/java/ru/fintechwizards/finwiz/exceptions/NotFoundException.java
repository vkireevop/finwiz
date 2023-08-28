package ru.fintechwizards.finwiz.exceptions;

public class NotFoundException extends RuntimeException{
  public NotFoundException(String message) {
    super(message);
  }
}
