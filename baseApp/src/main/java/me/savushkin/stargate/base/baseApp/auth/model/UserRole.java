package me.savushkin.stargate.base.baseApp.auth.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.GenerationType.SEQUENCE;

@Data
@Entity
@Table(name = "user_role")
public class UserRole {

    @Id
    @GeneratedValue(strategy = SEQUENCE)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @JsonIgnore
    @Column(name = "user_id", unique = true, nullable = false)
    private Long user;

    @Column(name = "role", nullable = false, length = 45)
    private String role;

}
