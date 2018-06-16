package me.savushkin.stargate.base.baseApp.command.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.savushkin.stargate.base.baseApp.auth.model.User;
import me.savushkin.stargate.base.baseApp.mission.model.Mission;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "command")
public class Command {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private CommandType commandType;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "command", fetch = FetchType.LAZY)
    private Set<User> members = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "command")
    private Set<Mission> missions = new HashSet<>();

    public Command(String name, CommandType commandType, String description, Set<User> members, Set<Mission> missions) {
        this.name = name;
        this.commandType = commandType;
        this.description = description;
        this.members = members;
        this.missions = missions;
    }
}