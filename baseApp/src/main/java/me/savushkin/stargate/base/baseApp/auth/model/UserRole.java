package me.savushkin.stargate.base.baseApp.auth.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserRole userRole = (UserRole) o;
        return Objects.equals(ID, userRole.ID) &&
                Objects.equals(user, userRole.user) &&
                Objects.equals(role, userRole.role);
    }

    @Override
    public int hashCode() {

        return Objects.hash(ID, user, role);
    }
}