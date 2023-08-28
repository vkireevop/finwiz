package ru.fintechwizards.finwiz.exceptions;

public class AlreadyExistsException extends RuntimeException{
  public AlreadyExistsException(String message) {
    super(message);
  }
}
