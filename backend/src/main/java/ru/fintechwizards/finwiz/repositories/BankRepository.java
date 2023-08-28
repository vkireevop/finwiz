package ru.fintechwizards.finwiz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.fintechwizards.finwiz.models.Bank;

import java.util.Optional;

@Repository
public interface BankRepository extends JpaRepository<Bank,Long> {
    @Override
    Optional<Bank> findById(Long id);
}
