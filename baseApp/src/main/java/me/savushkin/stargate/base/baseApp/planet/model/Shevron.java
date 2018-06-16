package me.savushkin.stargate.base.baseApp.planet.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "shevron")
public class Shevron {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 200)
    private String name;

    public Shevron(String name) {
        this.name = name;
    }
}