package me.savushkin.stargate.base.baseApp.planet.repository;

import me.savushkin.stargate.base.baseApp.planet.model.Zone;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ZoneRepository extends PagingAndSortingRepository<Zone, Long> {
}
