package ru.fintechwizards.finwiz.models;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Data
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

    public void debit(BigDecimal amount) {
        balance = balance.subtract(amount);
    }
    public void credit(BigDecimal amount) {
        balance = balance.add(amount);
    }
}








