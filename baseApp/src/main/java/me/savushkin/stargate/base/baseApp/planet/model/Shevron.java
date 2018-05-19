package me.savushkin.stargate.base.baseApp.planet.model;

import lombok.Data;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Data
@Entity
@Table(name = "address_star_gate")
public class Shevron {
    @Id
    @GeneratedValue(strategy = SEQUENCE)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 300)
    private String name;

    @Column(name = "glyph", nullable = false)
    private Integer glyph;
}
