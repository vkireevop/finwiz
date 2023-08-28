package ru.fintechwizards.finwiz.responses;

import java.util.List;
import ru.fintechwizards.finwiz.models.Account;

public class UserInfoResponse {
  private Long id;
  private String username;
  private boolean enabled;

  List<Account> accounts;

  public UserInfoResponse() {

  }

  public UserInfoResponse(Long id, String username, boolean enabled, List<Account> accounts) {
    this.id = id;
    this.username = username;
    this.enabled = enabled;
    this.accounts = accounts;
  }

  public Long getId() {
    return id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  public List<Account> getAccounts() {
    return accounts;
  }

  public void setAccounts(List<Account> accounts) {
    this.accounts = accounts;
  }
}
