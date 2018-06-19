package me.savushkin.stargate.gate.gateApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressStarGate {
    private Long id;
    private String humanName;
    private String physicalName;
    private Shevron Glyph1;
    private Shevron Glyph2;
    private Shevron Glyph3;
    private Shevron Glyph4;
    private Shevron Glyph5;
    private Shevron Glyph6;
    private Shevron Glyph7;
}