package me.savushkin.stargate.base.baseApp.auth.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.SEQUENCE;

@Data
@Entity
@Table(name = "\"user\"")
public class User {

    @Id
    @GeneratedValue(strategy = SEQUENCE)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "username", unique = true, nullable = false, length = 45)
    private String username;

    @Column(name = "name", nullable = true, length = 200)
    private String name;

    @Column(name = "second_name", nullable = true, length = 200)
    private String second_name;

    @Column(name = "surname", nullable = true, length = 200)
    private String surname;

    @Column(name = "rank", nullable = true, length = 200)
    private String rank;

    @JsonIgnore
    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Column(name = "enabled", nullable = false)
    private boolean enabled;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    private Set<UserRole> userRole = new HashSet<>(0);

    @Column(name = "command_id", nullable = true)
    private Long command;

}
