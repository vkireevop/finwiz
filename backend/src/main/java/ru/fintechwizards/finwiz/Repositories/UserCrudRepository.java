package ru.fintechwizards.finwiz.Repositories;

import org.springframework.data.repository.CrudRepository;
import ru.fintechwizards.finwiz.Models.User;

public interface UserCrudRepository extends CrudRepository<User, Long> {

}
