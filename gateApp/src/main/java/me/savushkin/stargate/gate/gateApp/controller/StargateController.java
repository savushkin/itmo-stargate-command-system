package me.savushkin.stargate.gate.gateApp.controller;

import me.savushkin.stargate.gate.gateApp.model.AddressStarGate;
import me.savushkin.stargate.gate.gateApp.service.StargateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/api/star-gate")
public class StargateController {

    private final StargateService stargateService;

    @Autowired()
    public StargateController(StargateService stargateService) {
        this.stargateService = stargateService;
    }

    @RequestMapping(path = "/state", method = RequestMethod.GET)
    public ResponseEntity getState() {
        try {
            return new ResponseEntity(stargateService.getState(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/toggle-iris", method = RequestMethod.GET)
    public ResponseEntity toggleIris() {
        try {
            stargateService.toggleIris();
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/open", method = RequestMethod.POST)
    public ResponseEntity open(@RequestBody AddressStarGate addressStarGate) {
        try {
            stargateService.open(addressStarGate);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/close", method = RequestMethod.GET)
    public ResponseEntity close() {
        try {
            stargateService.close();
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
