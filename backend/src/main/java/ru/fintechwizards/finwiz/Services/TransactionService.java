package ru.fintechwizards.finwiz.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fintechwizards.finwiz.Models.Transaction;
import ru.fintechwizards.finwiz.Repositories.TransactionRepository;

import java.util.List;
import java.util.Optional;

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
}
