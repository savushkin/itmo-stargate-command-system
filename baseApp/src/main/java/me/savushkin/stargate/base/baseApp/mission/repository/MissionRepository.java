package me.savushkin.stargate.base.baseApp.mission.repository;

import me.savushkin.stargate.base.baseApp.mission.model.Mission;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MissionRepository extends PagingAndSortingRepository<Mission, Long> {
}
