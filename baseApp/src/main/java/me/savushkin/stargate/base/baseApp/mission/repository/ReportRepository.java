package me.savushkin.stargate.base.baseApp.mission.repository;

import me.savushkin.stargate.base.baseApp.auth.model.User;
import me.savushkin.stargate.base.baseApp.mission.model.Report;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface ReportRepository extends PagingAndSortingRepository<Report, Long> {

}
