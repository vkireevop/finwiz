package ru.fintechwizards.finwiz.services;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.fintechwizards.finwiz.exceptions.NotFoundException;
import ru.fintechwizards.finwiz.models.Account;
import ru.fintechwizards.finwiz.repositories.AccountRepository;

import java.util.Optional;
import ru.fintechwizards.finwiz.requests.DepositMoneyRequest;
import ru.fintechwizards.finwiz.responses.AccountResponse;

@Service
public class AccountService {
    private final AccountRepository accRepo;
    @Autowired
    public AccountService (AccountRepository accRepo)
    {
        this.accRepo=accRepo;
    }
    public Optional<Account> findById(Long id) {
        return accRepo.findById(id);
    }

    public List<Account> getAllAccounts() {
        return accRepo.findAll();
    }

    public List<Account> findAccountsByUserId(Long id) {
        List<Account> accountList = accRepo.findAllByUser(id);
        return accountList;
    }

    public AccountResponse createAccount(Account account) {
        accRepo.save(account);
        return new AccountResponse(account.getAccountId(),
            account.getUser(), account.getBank(), account.getCurrency(), account.getBalance());
    }

    public AccountResponse addMoney(DepositMoneyRequest request) {
        Long accountId = request.getAccountId();
        BigDecimal amount = request.getAmount();

        Optional<Account> account = accRepo.findById(accountId);
        if (account.isPresent()) {
            account.get().credit(amount);
            accRepo.save(account.get());
            return new AccountResponse(accountId, account.get().getUser(), account.get().getBank(),
                account.get().getCurrency(), account.get().getBalance());
        }
        throw new NotFoundException("Account not found");
    }
}
