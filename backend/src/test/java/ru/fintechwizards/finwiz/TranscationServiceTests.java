package ru.fintechwizards.finwiz;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.fintechwizards.finwiz.models.Account;
import ru.fintechwizards.finwiz.models.User;
import ru.fintechwizards.finwiz.requests.TransactionRequest;
import ru.fintechwizards.finwiz.services.TransactionService;

public class TranscationServiceTests {
  @Autowired
  private TransactionService transactionService;

  @Test
  public void testTransactionButBalanceNotEnough() {

  }

  @Test
  public void testTranscationRUBtoRUB() throws IOException {
    Account senderAccount = new Account();
    Account receiverAccount = new Account();
    senderAccount.setBalance(BigDecimal.valueOf(1000));
    receiverAccount.setBalance(BigDecimal.valueOf(1000));

    senderAccount.setCurrency("RUB");
    receiverAccount.setCurrency("RUB");
    TransactionRequest req = new TransactionRequest("RUB",
        "RUB",
        senderAccount,
        receiverAccount,
        BigDecimal.valueOf(100),
        new Date(),
        "Description");
    transactionService.makeTransaction(req);


  }


}
