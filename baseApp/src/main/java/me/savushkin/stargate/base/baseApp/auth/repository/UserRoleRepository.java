package me.savushkin.stargate.base.baseApp.auth.repository;

import me.savushkin.stargate.base.baseApp.auth.model.UserRole;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UserRoleRepository extends PagingAndSortingRepository<UserRole, Long> {
    List<UserRole> findByUser(Long user);
    UserRole findByUserAndRole(Long user, String role);

    @Transactional
//    @Query(value = "delete from UserRole where user = :user")
    Long deleteAllByUser(Long user) ;
}
