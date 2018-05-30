package me.savushkin.stargate.base.baseApp.command.controller;

import me.savushkin.stargate.base.baseApp.command.model.CommandType;
import me.savushkin.stargate.base.baseApp.command.repository.CommandTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;

@Controller
@RequestMapping("/api/command-type")
public class CommandTypeController {
    private final CommandTypeRepository commandTypeRepository;

    @Autowired
    public CommandTypeController(CommandTypeRepository commandTypeRepository) {
        this.commandTypeRepository = commandTypeRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getPage(
            @RequestParam(name = "page", defaultValue = "0") Integer pageNum,
            @RequestParam(name = "size", defaultValue = "15") Integer size) {
        try {
            Page<CommandType> page = commandTypeRepository.findAll(new PageRequest(pageNum, size));
            return new ResponseEntity(page, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity getCommandType(
            @PathVariable("id") Long id
    ){
        try{
            CommandType typeCommand = commandTypeRepository.findOne(id);
            return new ResponseEntity(typeCommand, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity((HttpStatus.BAD_REQUEST));
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createCommandType(
            @RequestBody() CommandType commandType){
        try{
            return saveCommandType(commandType);
        }
        catch(Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public ResponseEntity updateCommandType(
            @RequestBody() CommandType commandType
    ){
        try{
            if(commandType.getId() == 0)
                return new ResponseEntity(HttpStatus.BAD_REQUEST);

            return saveCommandType(commandType);
        }
        catch(Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    private ResponseEntity saveCommandType(CommandType commandType){
        if( !commandType.getTypeName().isEmpty() ){
            CommandType saved = commandTypeRepository.save(commandType);
            return new ResponseEntity(saved, HttpStatus.CREATED);
        }
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}