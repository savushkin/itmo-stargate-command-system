package me.savushkin.stargate.base.baseApp.mission.repository;

import me.savushkin.stargate.base.baseApp.auth.model.User;
import me.savushkin.stargate.base.baseApp.mission.model.Mission;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface MissionRepository extends PagingAndSortingRepository<Mission, Long> {

}
