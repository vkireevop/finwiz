package ru.fintechwizards.finwiz.services;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fintechwizards.finwiz.exceptions.NotFoundException;
import ru.fintechwizards.finwiz.models.Account;
import ru.fintechwizards.finwiz.models.User;
import ru.fintechwizards.finwiz.repositories.AccountRepository;

import java.util.Optional;

import ru.fintechwizards.finwiz.repositories.BankRepository;
import ru.fintechwizards.finwiz.repositories.UserJpaRepository;
import ru.fintechwizards.finwiz.requests.AccountRequest;
import ru.fintechwizards.finwiz.requests.DepositMoneyRequest;
import ru.fintechwizards.finwiz.responses.AccountResponse;

@Service
public class AccountService {
    private final AccountRepository accRepo;
    private final UserJpaRepository usRepo;
    private final BankRepository bankRepository;
    @Autowired
    public AccountService (AccountRepository accRepo, UserJpaRepository usRepo, BankRepository bankRepository)
    {
        this.accRepo=accRepo;
        this.usRepo = usRepo;
        this.bankRepository = bankRepository;
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

    public void createAccount(AccountRequest account) {
        accRepo.save(new Account(usRepo.findById(account.getUser()).get(),bankRepository.findById(account.getBank()).get(),
                account.getCurrency(),account.getBalance()));
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
