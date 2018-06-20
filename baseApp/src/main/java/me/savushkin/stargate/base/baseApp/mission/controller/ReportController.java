package me.savushkin.stargate.base.baseApp.mission.controller;

import me.savushkin.stargate.base.baseApp.auth.model.User;
import me.savushkin.stargate.base.baseApp.command.repository.CommandRepository;
import me.savushkin.stargate.base.baseApp.mission.model.Mission;
import me.savushkin.stargate.base.baseApp.mission.model.Report;
import me.savushkin.stargate.base.baseApp.mission.repository.MissionRepository;
import me.savushkin.stargate.base.baseApp.mission.repository.ReportRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/api/report")
public class ReportController {

    MissionRepository missionRepository;
    ReportRepository reportRepository;
    CommandRepository commandRepository;

    public ReportController(MissionRepository missionRepository,
                            ReportRepository reportRepository,
                            CommandRepository commandRepository){
        this.missionRepository = missionRepository;
        this.reportRepository = reportRepository;
        this.commandRepository = commandRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getPage(
            @RequestParam(name = "page", defaultValue = "0") Integer pageNum,
            @RequestParam(name = "size", defaultValue = "15") Integer size) {
        try {
            Page<Report> page = reportRepository.findAll(new PageRequest(pageNum, size, new Sort(Sort.Direction.ASC, "id")));
            return new ResponseEntity(page, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity getReport(
            @PathVariable() Long id
    ) {
        try {
            Report report = reportRepository.findOne(id);
            return new ResponseEntity(report, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity create(
            @RequestBody() Report report
    ) {
        try {
            if(!modelIsValid(report))
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            Report saved = reportRepository.save(report);
            return new ResponseEntity(saved, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public ResponseEntity update(
            @RequestBody() Report report
    ){
        try{
            if(report.getId() <= 0 ||
                !modelIsValid(report))
                return new ResponseEntity(HttpStatus.BAD_REQUEST);

            Report saved = reportRepository.save(report);
            return new ResponseEntity(saved, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(
            @PathVariable() Long id
    ){
        try{
            if(id <= 0)
                return new ResponseEntity(HttpStatus.BAD_REQUEST);
            reportRepository.delete(id);
            return new ResponseEntity(HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    private boolean modelIsValid(Report report){
        if(report.getUser() == null ||
            report.getUser() != null && report.getUser().getId() <= 0 ||
            report.getMission() == null)
            return false;
        Mission mission = missionRepository.findOne(report.getMission().getId());
        Set<User> usersInMission = mission.getCommand().getMembers();

        List<User> resFilter = usersInMission.stream().filter(mis -> mis.getId().equals(report.getUser().getId())).collect(Collectors.toList());

        if(resFilter.isEmpty()){
            return false;
        }
        return true;
    }
}