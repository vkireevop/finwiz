package ru.fintechwizards.finwiz.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fintechwizards.finwiz.models.Account;
import ru.fintechwizards.finwiz.repositories.AccountRepository;

import java.util.Optional;
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
}
