package me.savushkin.stargate.base.baseApp.planet.repository;

import me.savushkin.stargate.base.baseApp.planet.model.AddressStarGate;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface AddressStarGateRepository extends PagingAndSortingRepository<AddressStarGate, Long> {
    List<AddressStarGate> findAll();
}
