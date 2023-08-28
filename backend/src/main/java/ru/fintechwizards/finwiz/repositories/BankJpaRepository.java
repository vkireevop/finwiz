package ru.fintechwizards.finwiz.repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import ru.fintechwizards.finwiz.models.Bank;

public interface BankJpaRepository extends JpaRepository<Bank, Long> {
  Optional<Bank> findByName(String name);
}
