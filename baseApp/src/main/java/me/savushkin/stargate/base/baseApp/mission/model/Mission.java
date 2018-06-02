package me.savushkin.stargate.base.baseApp.mission.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import me.savushkin.stargate.base.baseApp.auth.model.User;
import me.savushkin.stargate.base.baseApp.command.model.Command;
import me.savushkin.stargate.base.baseApp.planet.model.Zone;

import javax.persistence.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.SEQUENCE;
import static javax.persistence.GenerationType.TABLE;

@Data
@Entity
@Table(name = "mission")
public class Mission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, columnDefinition = "serial")
    private Long id;

    @Column(name = "name", length = 200, nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "date_create", nullable = false)
    private Date dateCreate;

    @Column(name = "date_departure", nullable = false)
    private Date dateDeparture;

    @ManyToOne
    @JoinColumn(name = "zone_to_id")
    private Zone zone;

    @ManyToOne
    @JoinColumn(name = "command_departure")
    private Command command;

    @OneToMany(mappedBy = "mission", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Report> report = new HashSet<>();
}