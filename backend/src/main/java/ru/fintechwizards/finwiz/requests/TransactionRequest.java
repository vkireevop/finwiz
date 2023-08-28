package ru.fintechwizards.finwiz.requests;

import java.math.BigDecimal;
import java.util.Date;
import ru.fintechwizards.finwiz.models.Account;

public class TransactionRequest {
  private String currencyStart;
  private String currencyFinal;
  private Long senderAccount;
  private Long receiverAccount;

  private BigDecimal amount;
  private Date date;
  private String description;

  public TransactionRequest() {}

  public TransactionRequest(String currencyStart, String currencyFinal,
      Long senderAccount, Long receiverAccount, BigDecimal amount, Date date,
      String description) {
    this.currencyStart = currencyStart;
    this.currencyFinal = currencyFinal;
    this.senderAccount = senderAccount;
    this.receiverAccount = receiverAccount;
    this.amount = amount;
    this.date = date;
    this.description = description;
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

  public Long getSenderAccount() {
    return senderAccount;
  }

  public void setSenderAccount(Long senderAccount) {
    this.senderAccount = senderAccount;
  }

  public Long getReceiverAccount() {
    return receiverAccount;
  }

  public void setReceiverAccount(Long receiverAccount) {
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
