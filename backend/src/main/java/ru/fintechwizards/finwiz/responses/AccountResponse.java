package ru.fintechwizards.finwiz.responses;

import java.math.BigDecimal;
import ru.fintechwizards.finwiz.models.Bank;
import ru.fintechwizards.finwiz.models.User;

public class AccountResponse {
  private Long accountId;
  private User user;

  private Bank bank;
  private String currency;
  private BigDecimal balance;

  public AccountResponse() {}

  public AccountResponse(Long accountId, User user, Bank bank, String currency,
      BigDecimal balance) {
    this.accountId = accountId;
    this.user = user;
    this.bank = bank;
    this.currency = currency;
    this.balance = balance;
  }

  public Long getAccountId() {
    return accountId;
  }

  public void setAccountId(Long accountId) {
    this.accountId = accountId;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Bank getBank() {
    return bank;
  }

  public void setBank(Bank bank) {
    this.bank = bank;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public BigDecimal getBalance() {
    return balance;
  }

  public void setBalance(BigDecimal balance) {
    this.balance = balance;
  }
}
