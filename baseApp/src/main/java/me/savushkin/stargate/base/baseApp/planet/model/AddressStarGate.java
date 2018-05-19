package me.savushkin.stargate.base.baseApp.planet.model;

import lombok.Data;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.SEQUENCE;

@Data
@Entity
@Table(name = "address_star_gate")
public class AddressStarGate {
    @Id
    @GeneratedValue(strategy = SEQUENCE)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "human_name", nullable = false, length = 200)
    private String human_name;

    @Column(name = "physical_name", nullable = false, length = 200)
    private String physical_name;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "address_shevrons",
            joinColumns = { @JoinColumn(name = "addres_id") },
            inverseJoinColumns = { @JoinColumn(name = "shevron_id") })
    private Set<Shevron> shevrons = new HashSet<>();
}