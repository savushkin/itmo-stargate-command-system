package me.savushkin.stargate.base.baseApp.planet.model;

import lombok.Data;
import me.savushkin.stargate.base.baseApp.mission.model.Mission;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.SEQUENCE;

@Data
@Entity
@Table(name = "zone")
public class Zone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "name", unique = true, nullable = false, length = 255)
    private String name;

    @Column(name = "climatic_conditions")
    private String climaticConditions;

    @Column(name = "mititary_threats")
    private String mititaryThreats;

    @Column(name = "minerals")
    private String minerals;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "address_id")
    private AddressStarGate addressStarGate;

    @OneToMany(mappedBy = "zone")
    private Set<Mission> missions = new HashSet<>();
}
