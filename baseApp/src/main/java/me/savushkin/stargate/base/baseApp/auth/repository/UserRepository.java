package me.savushkin.stargate.base.baseApp.auth.repository;

import me.savushkin.stargate.base.baseApp.auth.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.validation.constraints.Null;
import java.util.List;

public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    User findByUsername(String username);
    @Query(value = "select u.* from user_role inner join \"user\" u on user_role.user_id = u.id where user_role.role = :userRole and (command_id = :command or command_id is null)", nativeQuery = true)
    List<User> findUsersForAddToCommand(@Param("userRole") String userRole,
                                        @Param("command") @Null Long command);
    @Query(value = "select u.* from user_role inner join \"user\" u on user_role.user_id = u.id where user_role.role = :userRole and command_id is null", nativeQuery = true)
    List<User> findUsersForAddToCommand(@Param("userRole") String userRole);
}
