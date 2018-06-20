package me.savushkin.stargate.base.baseApp.mission.controller;

import me.savushkin.stargate.base.baseApp.command.repository.CommandRepository;
import me.savushkin.stargate.base.baseApp.mission.model.Mission;
import me.savushkin.stargate.base.baseApp.mission.repository.MissionRepository;
import me.savushkin.stargate.base.baseApp.planet.repository.ZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
            Page<Mission> page = missionRepository.findAll(new PageRequest(pageNum, size, new Sort(Sort.Direction.DESC, "dateDeparture")));
            return new ResponseEntity(page, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getMission(
            @PathVariable("id") Long id){
        try{
            Mission mission = missionRepository.findOne(id);
            return new ResponseEntity(mission, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity create(
            // @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
            @RequestBody() Mission missionData) {
        try {
            missionData.setDateCreate(new Date());
            missionData.setApproved(false);
            missionData.setCancel(false);
            return new ResponseEntity(missionRepository.save(missionData), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public ResponseEntity update(
            @RequestBody() Mission missionData,
            @PathVariable() Long id) {
        try {
            Mission mission = missionRepository.findOne(id);
            missionData.setId(mission.getId());
            return new ResponseEntity(missionRepository.save(missionData), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity delete(
            @PathVariable() Long id) {
        try {
            Mission mission = missionRepository.findOne(id);
            missionRepository.delete(mission.getId());
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}/cancel/")
    public ResponseEntity cancel(
            @PathVariable Long id
    ){
        try{
            Mission mission = missionRepository.findOne(id);
            mission.setCancel(true);
            missionRepository.save(mission);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}/approve/")
    public ResponseEntity approve(
            @PathVariable Long id
    ){
        try{
            Mission mission = missionRepository.findOne(id);
            if (!mission.getCancel()) {
                mission.setApproved(true);
                missionRepository.save(mission);
            }
            return new ResponseEntity(HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}