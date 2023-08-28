package ru.fintechwizards.finwiz.services;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.fintechwizards.finwiz.models.Account;
import ru.fintechwizards.finwiz.models.Transaction;
import ru.fintechwizards.finwiz.repositories.AccountRepository;
import ru.fintechwizards.finwiz.repositories.TransactionRepository;

import java.util.List;
import java.util.Optional;
import ru.fintechwizards.finwiz.requests.TransactionRequest;

@Service
public class TransactionService {

    private final TransactionRepository transactionRep;
    private final AccountRepository accountRepository;
    @Autowired
    public TransactionService (TransactionRepository transactionRep, AccountRepository accountRepository)
    {
        this.transactionRep = transactionRep;
        this.accountRepository = accountRepository;
    }
    public Optional<Transaction> findById(Long id) {
        return transactionRep.findById(id);
    }
    public List<Transaction> findAllSenderId(Long id) {
        return transactionRep.findAllBySenderId(id);
    }

    @Transactional
    public void makeTransaction(TransactionRequest request) throws IOException {
        Account senderAccount = request.getSenderAccount();
        Account receiverAccount = request.getReceiverAccount();
        String currencyStart = senderAccount.getCurrency();
        String currencyFinal = receiverAccount.getCurrency();
        BigDecimal amount = request.getAmount();
        Date date = request.getDate();
        String description = request.getDescription();
        Transaction transaction = new Transaction(request.getCurrencyStart(),request.getCurrencyFinal(),
                request.getSenderAccount(),request.getReceiverAccount(),
                request.getAmount(),request.getDate(),request.getDescription());
        if (currencyFinal.equals(currencyStart))
        {
            senderAccount.debit(amount);
            receiverAccount.credit(amount);
        }
        else {
            senderAccount.debit(amount);
            float rateStart = CurrencyService.getExchangeRate(currencyStart);
            float rateFinal = CurrencyService.getExchangeRate(currencyFinal);
            receiverAccount.credit(amount.divide(BigDecimal.valueOf(rateStart)).multiply(BigDecimal.valueOf(rateFinal)));
        }
        transactionRep.save(transaction);
        accountRepository.save(senderAccount);
        accountRepository.save(receiverAccount);
    }
}
