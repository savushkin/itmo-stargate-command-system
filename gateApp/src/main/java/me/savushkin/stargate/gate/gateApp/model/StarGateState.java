package me.savushkin.stargate.gate.gateApp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StarGateState {
   private String stargateState;
   private String irisState;
   private AddressStarGate addressStarGate;
}