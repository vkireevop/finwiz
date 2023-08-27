package ru.fintechwizards.finwiz.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.fintechwizards.finwiz.Models.Account;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long > {
    Optional<Account> findById(Long id);

}
