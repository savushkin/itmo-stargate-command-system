package me.savushkin.stargate.base.baseApp.planet.model;

import lombok.Data;

import javax.persistence.*;

import static javax.persistence.GenerationType.SEQUENCE;

@Data
@Entity
@Table(name = "zone")
public class Zone {

    @Id
    @GeneratedValue(strategy = SEQUENCE)
    @Column(name = "id", unique = true, nullable = false)
    private Long id;

    @Column(name = "name", unique = true, nullable = false, length = 255)
    private String name;

    @Column(name = "description", length = 4096)
    private String description;

    @Column(name = "glyph_1")
    private Integer glyph1;

    @Column(name = "glyph_2")
    private Integer glyph2;

    @Column(name = "glyph_3")
    private Integer glyph3;

    @Column(name = "glyph_4")
    private Integer glyph4;

    @Column(name = "glyph_5")
    private Integer glyph5;

    @Column(name = "glyph_6")
    private Integer glyph6;

    @Column(name = "glyph_7")
    private Integer glyph7;

    @Column(name = "glyph_8")
    private Integer glyph8;

}
