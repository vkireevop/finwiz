package ru.fintechwizards.finwiz.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.fintechwizards.finwiz.Models.Banks;
import ru.fintechwizards.finwiz.Repositories.BanksRepository;

import java.util.Optional;

@Service
public class BanksService {
    private final BanksRepository bankRep;
    @Autowired
    public BanksService (BanksRepository bankRep)
    {
        this.bankRep = bankRep;
    }
    public Optional<Banks> findById(Long id) {
        return bankRep.findById(id);
    }
}
