package ru.fintechwizards.finwiz.requests;

public class BankRequest {
  private String name;
  private String address;

  public BankRequest() {}

  public BankRequest(String name, String address) {
    this.name = name;
    this.address = address;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
