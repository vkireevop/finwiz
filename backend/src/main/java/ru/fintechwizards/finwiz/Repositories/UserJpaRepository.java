package ru.fintechwizards.finwiz.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import ru.fintechwizards.finwiz.Models.User;

public interface UserJpaRepository extends JpaRepository<User, Long> {

  Optional<User> findByUsername(String username);
}