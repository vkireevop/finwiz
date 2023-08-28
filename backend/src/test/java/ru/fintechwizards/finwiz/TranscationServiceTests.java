package ru.fintechwizards.finwiz;

import org.junit.jupiter.api.Test;
import ru.fintechwizards.finwiz.models.Account;
import ru.fintechwizards.finwiz.models.User;

public class TranscationServiceTests {

  @Test
  public void testTransactionButBalanceNotEnough() {

  }

  @Test
  public void testTranscationRUBtoRUB() {
    User sender = new User("Test_user1", "test");
    User receiver = new User("Test_user2", "test");
    Account senderAccount = new Account();
    Account receiverAccount = new Account();

  }


}
