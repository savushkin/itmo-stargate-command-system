package me.savushkin.stargate.base.baseApp.command.repository;

import me.savushkin.stargate.base.baseApp.command.model.Command;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CommandRepository extends PagingAndSortingRepository<Command, Long> {
}
