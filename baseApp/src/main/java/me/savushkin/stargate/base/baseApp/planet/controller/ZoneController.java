package me.savushkin.stargate.base.baseApp.planet.controller;

import me.savushkin.stargate.base.baseApp.command.model.Command;
import me.savushkin.stargate.base.baseApp.command.repository.CommandRepository;
import me.savushkin.stargate.base.baseApp.planet.model.AddressStarGate;
import me.savushkin.stargate.base.baseApp.planet.model.Zone;
import me.savushkin.stargate.base.baseApp.planet.repository.AddressStarGateRepository;
import me.savushkin.stargate.base.baseApp.planet.repository.ZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.net.ssl.HttpsURLConnection;
import javax.xml.ws.Response;
import java.util.List;

@Controller
@RequestMapping("/api/zone")
public class ZoneController {
    private final ZoneRepository zoneRepository;
    private final AddressStarGateRepository addressStarGateRepository;

    @Autowired
    public ZoneController(ZoneRepository zoneRepository,
                          AddressStarGateRepository addressStarGateRepository) {
        this.zoneRepository = zoneRepository;
        this.addressStarGateRepository = addressStarGateRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getPage(
            @RequestParam(name = "page", defaultValue = "0") Integer pageNum,
            @RequestParam(name = "size", defaultValue = "15") Integer size) {
        try {
            Page<Zone> page = zoneRepository.findAll(new PageRequest(pageNum, size));
            return new ResponseEntity(page, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path="/find", method = RequestMethod.GET)
    public ResponseEntity findByName(
            @RequestParam(name = "query", defaultValue = "") String query) {
        try {
            List<Zone> zones = zoneRepository.findByNameStartingWithOrderByName(query);
            return new ResponseEntity(zones, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getZone(
            @PathVariable("id") Long id){
        try{
            Zone zone = zoneRepository.findOne(id);
            return new ResponseEntity(zone, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createZone(
            @RequestBody() Zone zone){
        try{
            if(zone.getAddressStarGate() == null)
                return new ResponseEntity("Прикрепление Зоны к адресу Звездных врат обязательно!", HttpStatus.NO_CONTENT);
            Long address_id = zone.getAddressStarGate().getId();
            zone.setAddressStarGate(addressStarGateRepository.findOne(address_id));
            Zone zoneSaved = zoneRepository.save(zone);

            return new ResponseEntity(zoneRepository.findOne(zoneSaved.getId()), HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity deleteZone(
            @PathVariable("id") Long id){
        try{
            zoneRepository.delete(id);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public ResponseEntity updateZone(
            @RequestBody() Zone zone){
        try{
            if (zone.getAddressStarGate() == null)
                return new ResponseEntity("Прикрепление Зоны к адресу Звездных врат обязательно!", HttpStatus.NO_CONTENT);

            Zone zoneSaved = zoneRepository.save(zone);

            return new ResponseEntity(zoneRepository.findOne(zoneSaved.getId()), HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}