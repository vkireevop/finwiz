package ru.fintechwizards.finwiz.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fintechwizards.finwiz.models.Bank;
import ru.fintechwizards.finwiz.repositories.BankRepository;

import java.util.Optional;

@Service
public class BanksService {
    private final BankRepository bankRep;
    @Autowired
    public BanksService (BankRepository bankRep)
    {
        this.bankRep = bankRep;
    }
    public Optional<Bank> findById(Long id) {
        return bankRep.findById(id);
    }
}
