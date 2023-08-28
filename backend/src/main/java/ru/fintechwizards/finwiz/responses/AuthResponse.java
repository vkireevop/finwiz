package ru.fintechwizards.finwiz.responses;

public class AuthResponse {

  private String message;
  private String accessToken;

  public AuthResponse() {

  }

  public AuthResponse(String message, String accessToken) {
    this.message = message;
    this.accessToken = accessToken;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getAccessToken() {
    return accessToken;
  }

  public void setAccessToken(String accessToken) {
    this.accessToken = accessToken;
  }
}