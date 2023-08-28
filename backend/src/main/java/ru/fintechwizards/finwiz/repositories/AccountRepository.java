package ru.fintechwizards.finwiz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.fintechwizards.finwiz.models.Account;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long > {
    Optional<Account> findById(Long id);
    @Modifying
    @Query("UPDATE Account t SET t.balance = t.balance - :amount WHERE t.accountId = :id")
    void downBalanceById(@Param("id")Long id, @Param("amount")BigDecimal amount);
    @Modifying
    @Query("UPDATE Account t SET t.balance = t.balance + :amount where t.accountId = :id")
    void upBalanceById(@Param("id") Long id, @Param("amount") BigDecimal amount);
}
