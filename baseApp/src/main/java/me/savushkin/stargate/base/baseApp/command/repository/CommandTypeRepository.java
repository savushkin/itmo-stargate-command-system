package me.savushkin.stargate.base.baseApp.command.repository;

import me.savushkin.stargate.base.baseApp.command.model.CommandType;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CommandTypeRepository extends PagingAndSortingRepository<CommandType, Long> {
}
