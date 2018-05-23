package me.savushkin.stargate.base.baseApp.planet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

import static javax.persistence.GenerationType.SEQUENCE;

@Data
@Entity
@Table(name = "address_star_gate")
public class AddressStarGate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "human_name", nullable = false, length = 200)
    private String humanName;

    @Column(name = "physical_name", nullable = false, length = 200)
    private String physicalName;

    @ManyToOne
    @JoinColumn(name = "glyph1")
    private Shevron Glyph1;

    @ManyToOne
    @JoinColumn(name = "glyph2")
    private Shevron Glyph2;

    @ManyToOne
    @JoinColumn(name = "glyph3")
    private Shevron Glyph3;

    @ManyToOne
    @JoinColumn(name = "glyph4")
    private Shevron Glyph4;

    @ManyToOne
    @JoinColumn(name = "glyph5")
    private Shevron Glyph5;

    @ManyToOne
    @JoinColumn(name = "glyph6")
    private Shevron Glyph6;

    @ManyToOne
    @JoinColumn(name = "glyph7")
    private Shevron Glyph7;
}