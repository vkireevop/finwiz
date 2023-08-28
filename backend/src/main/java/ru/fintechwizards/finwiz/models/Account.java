package ru.fintechwizards.finwiz.models;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "bank_id")
    private Bank bank;
    private String currency;
    private BigDecimal balance;

    public Account() {}

    public Account(User user, Bank bank, String currency, BigDecimal balance) {
        this.user = user;
        this.bank = bank;
        this.currency = currency;
        this.balance = balance;
    }

    public Long getAccountId() {
        return accountId;
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

    public void debit(BigDecimal amount) {
        balance = balance.subtract(amount);
    }
    public void credit(BigDecimal amount) {
        balance = balance.add(amount);
    }
}








