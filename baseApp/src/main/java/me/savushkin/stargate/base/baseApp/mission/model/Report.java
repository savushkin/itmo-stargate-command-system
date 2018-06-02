package me.savushkin.stargate.base.baseApp.mission.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @ManyToOne
    @JoinColumn(name = "mission_id", nullable = false)
    @JsonIgnore
    private Mission mission;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "report_date", nullable = false)
    private Date reportDate;
}