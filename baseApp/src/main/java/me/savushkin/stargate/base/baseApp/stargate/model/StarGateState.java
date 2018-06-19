package me.savushkin.stargate.base.baseApp.stargate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.savushkin.stargate.base.baseApp.planet.model.AddressStarGate;
import me.savushkin.stargate.base.baseApp.planet.model.Shevron;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StarGateState {
   private String stargateState;
   private String irisState;
   private AddressStarGate addressStarGate;
}