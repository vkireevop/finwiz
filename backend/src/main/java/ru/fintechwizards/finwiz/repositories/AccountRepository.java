package ru.fintechwizards.finwiz.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.fintechwizards.finwiz.models.Account;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long > {
    Optional<Account> findById(Long id);
    @Query("SELECT u FROM Account u WHERE u.user.id = :id")
    List<Account> findAllByUser(Long id);

}
