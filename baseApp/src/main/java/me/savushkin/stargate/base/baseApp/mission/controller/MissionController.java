package me.savushkin.stargate.base.baseApp.mission.controller;

import me.savushkin.stargate.base.baseApp.auth.model.User;
import me.savushkin.stargate.base.baseApp.command.repository.CommandRepository;
import me.savushkin.stargate.base.baseApp.mission.model.Mission;
import me.savushkin.stargate.base.baseApp.mission.repository.MissionRepository;
import me.savushkin.stargate.base.baseApp.planet.repository.ZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/api/mission")
public class MissionController {
    private final MissionRepository missionRepository;
    private final ZoneRepository zoneRepository;
    private final CommandRepository commandRepository;

    @Autowired
    public MissionController(MissionRepository missionRepository,
                             ZoneRepository zoneRepository,
                             CommandRepository commandRepository) {
        this.missionRepository = missionRepository;
        this.zoneRepository = zoneRepository;
        this.commandRepository = commandRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getPage(
            @RequestParam(name = "page", defaultValue = "0") Integer pageNum,
            @RequestParam(name = "size", defaultValue = "15") Integer size) {
        try {
            Page<Mission> page = missionRepository.findAll(new PageRequest(pageNum, size));
            return new ResponseEntity(page, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity create(
            @RequestParam() String name,
            @RequestParam() String description,
            @RequestParam() @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") Date dateCreate,
            @RequestParam() @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") Date dateDeparture,
            @RequestParam() Boolean approved,
            @RequestParam() Long zoneId,
            @RequestParam() Long commandId) {
        try {
            Mission mission = new Mission();
            mission.setName(name);
            mission.setDescription(description);
            mission.setDateCreate(dateCreate);
            mission.setDateDeparture(dateDeparture);
            mission.setZone(zoneRepository.findOne(zoneId));
            mission.setCommand(commandRepository.findOne(commandId));
            mission.setApproved(approved);
            mission.setCancel(false);
            return new ResponseEntity(missionRepository.save(mission), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public ResponseEntity update(
            @RequestParam() String name,
            @RequestParam() String description,
            @RequestParam() @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") Date dateCreate,
            @RequestParam() @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") Date dateDeparture,
            @RequestParam() Boolean approved,
            @RequestParam() Long zoneId,
            @RequestParam() Long commandId,
            @PathVariable() Long id) {
        try {
            Mission mission = missionRepository.findOne(id);

            mission.setName(name);
            mission.setDescription(description);
            mission.setDateCreate(dateCreate);
            mission.setDateDeparture(dateDeparture);
            mission.setZone(zoneRepository.findOne(zoneId));
            mission.setCommand(commandRepository.findOne(commandId));
            mission.setApproved(approved);

            return new ResponseEntity(missionRepository.save(mission), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}/cancel/{cancel}")
    public ResponseEntity cancel(
            @PathVariable Long id,
            @PathVariable Boolean cancel
    ){
        try{
            Mission mission = missionRepository.findOne(id);
            mission.setCancel(cancel);
            missionRepository.save(mission);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}