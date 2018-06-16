package me.savushkin.stargate.base.baseApp.planet.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
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

    public AddressStarGate(String humanName, String physicalName, Shevron glyph1, Shevron glyph2, Shevron glyph3, Shevron glyph4, Shevron glyph5, Shevron glyph6, Shevron glyph7) {
        this.humanName = humanName;
        this.physicalName = physicalName;
        Glyph1 = glyph1;
        Glyph2 = glyph2;
        Glyph3 = glyph3;
        Glyph4 = glyph4;
        Glyph5 = glyph5;
        Glyph6 = glyph6;
        Glyph7 = glyph7;
    }
}