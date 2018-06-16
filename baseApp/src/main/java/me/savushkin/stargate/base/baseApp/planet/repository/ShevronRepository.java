package me.savushkin.stargate.base.baseApp.planet.repository;

import me.savushkin.stargate.base.baseApp.planet.model.Shevron;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ShevronRepository extends PagingAndSortingRepository<Shevron, Long> {
    List<Shevron> findAll();
}
