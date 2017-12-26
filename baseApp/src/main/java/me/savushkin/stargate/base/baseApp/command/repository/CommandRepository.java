package me.savushkin.stargate.base.baseApp.command.repository;

import me.savushkin.stargate.base.baseApp.command.model.Command;
import me.savushkin.stargate.base.baseApp.planet.model.Zone;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CommandRepository extends PagingAndSortingRepository<Command, Long> {
    List<Command> findByCommandTypeTypeNameStartingWith(String typeName);
}
