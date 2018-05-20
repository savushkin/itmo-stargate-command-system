package me.savushkin.stargate.base.baseApp.mission.model;

import lombok.Data;
import me.savushkin.stargate.base.baseApp.auth.model.User;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "report")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, columnDefinition = "serial")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToOne
    @JoinColumn(name = "mission_id", nullable = false)
    private Mission mission;

    @JoinColumn(name = "description", nullable = false)
    private String description;

    @JoinColumn(name = "report_date", nullable = false)
    private Date reportDate;
}