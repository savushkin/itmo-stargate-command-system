package me.savushkin.stargate.base.baseApp.planet.repository;

import me.savushkin.stargate.base.baseApp.planet.model.Zone;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ZoneRepository extends PagingAndSortingRepository<Zone, Long> {
    List<Zone> findByNameStartingWithOrderByName(String name);
}
