package ru.fintechwizards.finwiz.services;

import java.io.IOException;
import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import ru.fintechwizards.finwiz.exceptions.NotEnoughException;
import ru.fintechwizards.finwiz.exceptions.NotFoundException;
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
    private AccountService accountService;
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

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    public void makeTransaction(TransactionRequest request) throws IOException, NotEnoughException {
        Optional<Account> senderAccount = accountService.findById(request.getSenderAccount());
        Optional<Account> receiverAccount = accountService.findById(request.getReceiverAccount());
        if (senderAccount.isEmpty() || receiverAccount.isEmpty()) {
            throw new NotFoundException("Account not found");
        }
        String currencyStart = senderAccount.get().getCurrency();
        String currencyFinal = receiverAccount.get().getCurrency();
        BigDecimal amount = request.getAmount();
        Transaction transaction = new Transaction(request.getCurrencyStart(),request.getCurrencyFinal(),
                senderAccount.get(),receiverAccount.get(),
                request.getAmount(),request.getDate(),request.getDescription());

        if (currencyFinal.equals(currencyStart))
        {
            senderAccount.get().debit(amount);
            receiverAccount.get().credit(amount);
        }
        else {
            senderAccount.get().debit(amount);
            float rateStart = CurrencyService.getExchangeRate(currencyStart);
            float rateFinal = CurrencyService.getExchangeRate(currencyFinal);
            receiverAccount.get().credit(amount.divide(BigDecimal.valueOf(rateStart)).multiply(BigDecimal.valueOf(rateFinal)));
        }
        transactionRep.save(transaction);
        accountRepository.save(senderAccount.get());
        accountRepository.save(receiverAccount.get());
    }
}
