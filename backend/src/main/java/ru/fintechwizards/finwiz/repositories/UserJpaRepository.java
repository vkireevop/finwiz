package ru.fintechwizards.finwiz.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import ru.fintechwizards.finwiz.models.User;

public interface UserJpaRepository extends JpaRepository<User, Long> {

  Optional<User> findByUsername(String username);
}