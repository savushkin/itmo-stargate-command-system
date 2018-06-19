package me.savushkin.stargate.gate.gateApp.controller;

import me.savushkin.stargate.gate.gateApp.model.AddressStarGate;
import me.savushkin.stargate.gate.gateApp.model.StarGateState;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/api/star-gate")
public class StargateController {

    @RequestMapping(path = "/state", method = RequestMethod.GET)
    public ResponseEntity getState() {
        try {
            StarGateState starGateState = new StarGateState();
            starGateState.setIrisState("IDLE");
            starGateState.setStargateState("IDLE");
            return new ResponseEntity(starGateState, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/toggle-iris", method = RequestMethod.GET)
    public ResponseEntity toggleIris() {
        try {
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/open", method = RequestMethod.POST)
    public ResponseEntity open(@RequestBody AddressStarGate addressStarGate) {
        try {
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/close", method = RequestMethod.GET)
    public ResponseEntity close() {
        try {
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
