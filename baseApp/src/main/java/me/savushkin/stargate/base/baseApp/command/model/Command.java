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

    @ManyToOne
    @JoinColumn(name = "command_type_id")
    private CommandType commandType;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "command", cascade = CascadeType.ALL)
    private Set<User> members = new HashSet<>(0);


}
