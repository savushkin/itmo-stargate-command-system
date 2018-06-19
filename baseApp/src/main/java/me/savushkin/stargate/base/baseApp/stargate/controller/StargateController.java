package me.savushkin.stargate.base.baseApp.stargate.controller;

import me.savushkin.stargate.base.baseApp.planet.model.AddressStarGate;
import me.savushkin.stargate.base.baseApp.planet.repository.AddressStarGateRepository;
import me.savushkin.stargate.base.baseApp.stargate.model.StarGateState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

@Controller
@RequestMapping("/api/star-gate")
public class StargateController {
    private final AddressStarGateRepository addressStarGateRepository;
    private final RestTemplate restTemplate = new RestTemplate();
    private final String ENDPOINT = "http://localhost:8083/api/star-gate";
    @Autowired
    public StargateController(AddressStarGateRepository addressStarGateRepository){
        this.addressStarGateRepository = addressStarGateRepository;
    }

    @RequestMapping(path = "/state", method = RequestMethod.GET)
    public ResponseEntity getState() {
        try {
            return restTemplate.getForEntity(ENDPOINT + "/state", StarGateState.class);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/toggle-iris", method = RequestMethod.GET)
    public ResponseEntity toggleIris() {
        try {
            return restTemplate.getForEntity(ENDPOINT + "/toggle-iris", Object.class);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/open/{id}", method = RequestMethod.GET)
    public ResponseEntity open(@PathVariable("id") Long id) {
        try {
            AddressStarGate addressStarGate = addressStarGateRepository.findOne(id);

            return restTemplate.postForEntity(ENDPOINT + "/open", addressStarGate, Object.class);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/close", method = RequestMethod.GET)
    public ResponseEntity close() {
        try {
            return restTemplate.getForEntity(ENDPOINT + "/close", Object.class);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
