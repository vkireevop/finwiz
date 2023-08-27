package ru.fintechwizards.finwiz.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.fintechwizards.finwiz.Models.Banks;

import java.util.Optional;

@Repository
public interface BanksRepository extends JpaRepository<Banks,Long> {
    @Override
    Optional<Banks> findById(Long id);
}
