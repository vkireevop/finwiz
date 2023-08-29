package ru.fintechwizards.finwiz.requests;

import java.math.BigDecimal;
public class AccountRequest {

    private Long accountId;
    private Long user;

    private Long bank;
    private String currency;
    private BigDecimal balance;

    public AccountRequest() {}

    public AccountRequest (Long accountId, Long user, Long bank, String currency,
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

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public Long getBank() {
        return bank;
    }

    public void setBank(Long bank) {
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