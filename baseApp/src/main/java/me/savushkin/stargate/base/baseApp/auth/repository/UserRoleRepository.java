package me.savushkin.stargate.base.baseApp.auth.repository;

import me.savushkin.stargate.base.baseApp.auth.model.UserRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRoleRepository extends PagingAndSortingRepository<UserRole, String> {
}
