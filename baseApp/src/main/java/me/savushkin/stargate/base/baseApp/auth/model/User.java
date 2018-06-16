package me.savushkin.stargate.base.baseApp.auth.model;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.savushkin.stargate.base.baseApp.command.model.Command;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.SEQUENCE;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "\"user\"")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "username", unique = true, nullable = false, length = 45)
    private String username;

    @Column(name = "name", nullable = true, length = 200)
    private String name;

    @Column(name = "second_name", nullable = true, length = 200)
    private String secondName;

    @Column(name = "surname", nullable = true, length = 200)
    private String surname;

    @Column(name = "rank", nullable = true, length = 200)
    private String rank;

    @JsonIgnore
    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Column(name = "enabled", nullable = false)
    private boolean enabled;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "command_id", nullable = true)
//    private Command command;
    @Column(name = "command_id")
    private Long command;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
    private Set<UserRole> userRole = new HashSet<>(0);

    public User(String username, String name, String secondName, String surname, String rank, String password, boolean enabled, Set<UserRole> userRole) {
        this.username = username;
        this.name = name;
        this.secondName = secondName;
        this.surname = surname;
        this.rank = rank;
        this.password = password;
        this.enabled = enabled;
        this.userRole = userRole;
    }
}