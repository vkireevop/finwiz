package ru.fintechwizards.finwiz.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;
import ru.fintechwizards.finwiz.Models.Transaction;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {

    Optional<Transaction> findById(Long id);
    @Query("SELECT t FROM Transaction t WHERE t.senderAccount.user.id = :id")
    List<Transaction> findAllBySenderId(@Param("id") Long id);
}
