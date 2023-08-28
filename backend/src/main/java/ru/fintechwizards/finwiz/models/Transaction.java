package ru.fintechwizards.finwiz.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    private String currencyStart;
    private String currencyFinal;

    @ManyToOne
    @JoinColumn(name = "sender_account_id")
    private Account senderAccount;

    @ManyToOne
    @JoinColumn(name = "receiver_account_id")
    private Account receiverAccount;

    private BigDecimal amount;
    private Date date;
    private String description;

    public Transaction() {}

    public Transaction(String currencyStart, String currencyFinal, Account senderAccount,
        Account receiverAccount, BigDecimal amount, Date date, String description) {
        this.currencyStart = currencyStart;
        this.currencyFinal = currencyFinal;
        this.senderAccount = senderAccount;
        this.receiverAccount = receiverAccount;
        this.amount = amount;
        this.date = date;
        this.description = description;
    }

    public Long getTransactionId() {
        return transactionId;
    }

    public String getCurrencyStart() {
        return currencyStart;
    }

    public void setCurrencyStart(String currencyStart) {
        this.currencyStart = currencyStart;
    }

    public String getCurrencyFinal() {
        return currencyFinal;
    }

    public void setCurrencyFinal(String currencyFinal) {
        this.currencyFinal = currencyFinal;
    }

    public Account getSenderAccount() {
        return senderAccount;
    }

    public void setSenderAccount(Account senderAccount) {
        this.senderAccount = senderAccount;
    }

    public Account getReceiverAccount() {
        return receiverAccount;
    }

    public void setReceiverAccount(Account receiverAccount) {
        this.receiverAccount = receiverAccount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
