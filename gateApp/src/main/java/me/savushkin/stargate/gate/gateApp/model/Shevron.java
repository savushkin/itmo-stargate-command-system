package me.savushkin.stargate.gate.gateApp.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
public class Shevron {
    private Long id;
    private String name;
}