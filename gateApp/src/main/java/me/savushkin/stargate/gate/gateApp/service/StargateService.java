package me.savushkin.stargate.gate.gateApp.service;

import me.savushkin.stargate.gate.gateApp.model.AddressStarGate;
import me.savushkin.stargate.gate.gateApp.model.StarGateState;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(value = "singleton")
public class StargateService {
    private final String STATE_IDLE = "IDLE";
    private final String STATE_OPEN = "OPEN";
    private final String STATE_CLOSE = "CLOSE";

    private StarGateState starGateState = new StarGateState();

    public StargateService() {
        starGateState.setStargateState(STATE_IDLE);
        starGateState.setIrisState(STATE_IDLE);
    }

    public StarGateState getState() {
        return starGateState;
    }

    public void toggleIris() {
        if (starGateState.getIrisState().equals(STATE_IDLE))
            starGateState.setIrisState(STATE_CLOSE);
        else
            starGateState.setIrisState(STATE_IDLE);
    }

    public void open(AddressStarGate addressStarGate) {
        if (starGateState.getStargateState().equals(STATE_IDLE)) {
            starGateState.setStargateState(STATE_OPEN);
            starGateState.setAddressStarGate(addressStarGate);
        }
    }

    public void close() {
        if (starGateState.getStargateState().equals(STATE_OPEN)) {
            starGateState.setStargateState(STATE_IDLE);
            starGateState.setAddressStarGate(null);
        }
    }
}
