package me.savushkin.stargate.base.baseApp.mission.repository;

import me.savushkin.stargate.base.baseApp.mission.model.Report;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ReportRepository extends PagingAndSortingRepository<Report, Long> {

}
