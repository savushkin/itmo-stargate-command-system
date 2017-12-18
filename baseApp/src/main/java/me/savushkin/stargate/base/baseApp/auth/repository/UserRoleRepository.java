package me.savushkin.stargate.base.baseApp.auth.repository;

import me.savushkin.stargate.base.baseApp.auth.model.UserRole;
import org.springframework.data.repository.CrudRepository;

public interface UserRoleRepository extends CrudRepository<UserRole, String> {
}
