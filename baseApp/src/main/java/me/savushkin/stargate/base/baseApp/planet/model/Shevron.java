package me.savushkin.stargate.base.baseApp.planet.model;

import lombok.Data;
import me.savushkin.stargate.base.baseApp.mission.model.Mission;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "shevron")
public class Shevron {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 200)
    private String name;
}