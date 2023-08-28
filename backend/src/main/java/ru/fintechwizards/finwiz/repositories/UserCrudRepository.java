package ru.fintechwizards.finwiz.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.fintechwizards.finwiz.models.User;

public interface UserCrudRepository extends CrudRepository<User, Long> {

}
