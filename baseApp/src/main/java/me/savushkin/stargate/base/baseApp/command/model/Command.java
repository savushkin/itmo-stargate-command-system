package me.savushkin.stargate.base.baseApp.command.model;

import lombok.Data;
import me.savushkin.stargate.base.baseApp.auth.model.User;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.SEQUENCE;

@Data
@Entity
@Table(name = "command")
public class Command {

    @Id
    @GeneratedValue(strategy = SEQUENCE)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private CommandType commandType;

    @Column(name = "description")
    private String description;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "command", cascade = CascadeType.ALL)
    private Set<User> members = new HashSet<>(0);
}