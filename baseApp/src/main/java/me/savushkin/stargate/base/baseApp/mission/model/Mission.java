package me.savushkin.stargate.base.baseApp.mission.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
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
@NoArgsConstructor
@AllArgsConstructor
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

    @Column(name = "approved", nullable = false)
    private Boolean approved;

    @Column(name = "cancel", nullable = false)
    private Boolean cancel;

    @ManyToOne
    @JoinColumn(name = "zone_to_id")
    private Zone zone;

    @ManyToOne
    @JoinColumn(name = "command_departure")
    private Command command;

    @OneToMany(mappedBy = "mission", fetch = FetchType.LAZY)
    private Set<Report> mission  = new HashSet<>();
}