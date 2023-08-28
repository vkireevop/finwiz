package ru.fintechwizards.finwiz.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fintechwizards.finwiz.exceptions.AlreadyExistsException;
import ru.fintechwizards.finwiz.exceptions.NotFoundException;
import ru.fintechwizards.finwiz.models.Bank;
import ru.fintechwizards.finwiz.repositories.BankJpaRepository;
import ru.fintechwizards.finwiz.repositories.BankRepository;

import java.util.Optional;

import ru.fintechwizards.finwiz.requests.BankRequest;
import ru.fintechwizards.finwiz.responses.BankResponse;

@Service
public class BanksService {
    private final BankRepository bankRep;

    @Autowired
    private BankJpaRepository bankJpaRepository;
    @Autowired
    public BanksService (BankRepository bankRep)
    {
        this.bankRep = bankRep;
    }
    public Optional<Bank> findById(Long id) {
        return bankRep.findById(id);
    }

    public List<Bank> getAllBanks() {
        return bankJpaRepository.findAll();
    }

    public BankResponse getBankById(Long id) {
        Optional<Bank> bank = bankJpaRepository.findById(id);
        if (bank.isPresent()) {
            Bank bankEntity = bank.get();
            return new BankResponse(bankEntity.getBankId(),
                bankEntity.getName(),
                bankEntity.getAddress());
        }
        throw new NotFoundException("Bank not found");
    }


    public BankResponse createBank(BankRequest request) {
        String name = request.getName();
        String address = request.getAddress();
        if (bankJpaRepository.findByName(name).isPresent()) {
            throw new AlreadyExistsException("Bank already exists");
        }
        Bank bank = new Bank(name, address);
        bankRep.save(bank);
        return new BankResponse(bank.getBankId(), bank.getName(), bank.getAddress());
    }
}
