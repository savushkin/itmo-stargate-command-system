package me.savushkin.stargate.base.baseApp.auth.repository;

import me.savushkin.stargate.base.baseApp.auth.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
