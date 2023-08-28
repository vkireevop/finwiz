package ru.fintechwizards.finwiz.services;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fintechwizards.finwiz.models.Account;
import ru.fintechwizards.finwiz.models.Transaction;
import ru.fintechwizards.finwiz.repositories.TransactionRepository;

import java.util.List;
import java.util.Optional;
import ru.fintechwizards.finwiz.requests.TransactionRequest;

@Service
public class TransactionService {

    private final TransactionRepository transactionRep;
    @Autowired
    public TransactionService (TransactionRepository transactionRep)
    {
        this.transactionRep = transactionRep;
    }
    public Optional<Transaction> findById(Long id) {
        return transactionRep.findById(id);
    }
    public List<Transaction> findAllSenderId(Long id) {
        return transactionRep.findAllBySenderId(id);
    }

    public void makeTransaction(TransactionRequest request) throws IOException {
        // Варианты: иностранная валюта и рубль
        // USD -> RUB, RUB -> USD, RUB -> RUB, CHF -> USD, USD -> USD
        // промежуточная валюта - рубль
        Account senderAccount = request.getSenderAccount();
        Account receiverAccount = request.getReceiverAccount();
        String currencyStart = request.getCurrencyStart();
        String currencyFinal = request.getCurrencyFinal();
        BigDecimal amount = request.getAmount();
        Date date = request.getDate();
        String description = request.getDescription();

        BigDecimal transitionCurrency = new BigDecimal(String.valueOf(amount));
        if (!Objects.equals(currencyStart, "RUB")) {
            float rate = CurrencyService.getExchangeRate(currencyStart);
            transitionCurrency = transitionCurrency.multiply(BigDecimal.valueOf(rate));
        } else {
            transitionCurrency = amount;
        }

        if (!Objects.equals(currencyFinal, "RUB")) {
            amount = transitionCurrency.divide(BigDecimal.valueOf(CurrencyService.getExchangeRate(currencyFinal))) ;
        } else {
            amount = transitionCurrency;
        }

        // TODO: TRANSACTIONS
    }
}
