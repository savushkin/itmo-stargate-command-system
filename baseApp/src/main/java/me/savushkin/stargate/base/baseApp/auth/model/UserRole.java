package me.savushkin.stargate.base.baseApp.auth.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;
import static javax.persistence.GenerationType.SEQUENCE;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_role")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long ID;

    @JsonIgnore
    @Column(name = "user_id", unique = true, nullable = false)
    private Long user;

    @Column(name = "role", nullable = false, length = 200)
    private String role;

    public UserRole(Long user, String role) {
        this.user = user;
        this.role = role;
    }
}