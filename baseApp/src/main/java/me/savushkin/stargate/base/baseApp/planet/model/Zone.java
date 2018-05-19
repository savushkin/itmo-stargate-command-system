package me.savushkin.stargate.base.baseApp.planet.model;

import lombok.Data;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Data
@Entity
@Table(name = "zone")
public class Zone {

    @Id
    @GeneratedValue(strategy = SEQUENCE)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "name", unique = true, nullable = false, length = 255)
    private String name;

    @Column(name = "climatic_conditions")
    private String climatic_conditions;

    @Column(name = "mititary_threats")
    private String mititary_threats;

    @Column(name = "minerals")
    private String minerals;

    @OneToOne(fetch = FetchType.LAZY)
    private AddressStarGate addressStarGate;
}
