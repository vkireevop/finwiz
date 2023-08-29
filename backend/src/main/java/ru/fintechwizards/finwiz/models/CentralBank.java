package ru.fintechwizards.finwiz.models;

import java.math.BigDecimal;

public class CentralBank {
    private static final CentralBank INSTANCE = new CentralBank();
    private CentralBank() {

    }
    public static CentralBank getInstance() {
        return INSTANCE;
    }
    public boolean buyCurrency(Account account, BigDecimal amount, String currency) {

        BigDecimal currentBalance = account.getBalance();
        BigDecimal newBalance = currentBalance.subtract(amount);
        account.setBalance(newBalance);

        return true;
    }
}
