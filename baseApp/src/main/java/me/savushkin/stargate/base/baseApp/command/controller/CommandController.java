package me.savushkin.stargate.base.baseApp.command.controller;

import me.savushkin.stargate.base.baseApp.auth.model.User;
import me.savushkin.stargate.base.baseApp.auth.repository.UserRepository;
import me.savushkin.stargate.base.baseApp.command.model.Command;
import me.savushkin.stargate.base.baseApp.command.repository.CommandRepository;
import me.savushkin.stargate.base.baseApp.command.repository.CommandTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/api/command")
public class CommandController {
    private final CommandRepository commandRepository;
    private final CommandTypeRepository commandTypeRepository;
    private final UserRepository userRepository;

    @Autowired
    public CommandController(CommandRepository commandRepository,
                             CommandTypeRepository commandTypeRepository,
                             UserRepository userRepository) {
        this.commandRepository = commandRepository;
        this.commandTypeRepository = commandTypeRepository;
        this.userRepository = userRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getPage(
            @RequestParam(name = "page", defaultValue = "0") Integer pageNum,
            @RequestParam(name = "size", defaultValue = "15") Integer size) {
        try {
            Page<Command> page = commandRepository.findAll(new PageRequest(pageNum, size, new Sort(Sort.Direction.ASC, "id")));
            return new ResponseEntity(page, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(path="/find", method = RequestMethod.GET)
    public ResponseEntity findByCommandTypeName(
            @RequestParam(name = "query", defaultValue = "") String query) {
        try {
            List<Command> commands = commandRepository.findByCommandTypeTypeNameStartingWith(query);
            return new ResponseEntity(commands, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity getCommand(
            @PathVariable() Long id
    ){
        try{
            Command command = commandRepository.findOne(id);
            return new ResponseEntity(command, HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createCommand(
            @RequestBody() Command command
    ){
        try{
            if(command.getMembers() == null ||
                command.getMembers() != null &&
                    command.getMembers().size() == 0)
                return new ResponseEntity(HttpStatus.BAD_REQUEST);

            Set<User> usersCommand = command.getMembers();
            Command saved = commandRepository.save(command);

            usersCommand.forEach(user -> {
                User userToSave = userRepository.findOne(user.getId());
                userToSave.setCommand(saved.getId());
                userRepository.save(userToSave);
            });

            return new ResponseEntity(commandRepository.findOne(saved.getId()), HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public ResponseEntity updateCommand(
            @RequestBody() Command command,
            @PathVariable Long id
    ){
        try{
            if(command.getMembers() == null ||
                    command.getMembers() != null &&
                            command.getMembers().size() == 0)
                return new ResponseEntity(HttpStatus.BAD_REQUEST);

            List<User> oldUsersCommand = userRepository.findUserByCommand(command.getId());

            oldUsersCommand.forEach(user -> {
                user.setCommand(null);
                userRepository.save(user);
            });

            Set<User> usersCommand = command.getMembers();
            Command saved = commandRepository.save(command);

            usersCommand.forEach(user -> {
                User userToSave = userRepository.findOne(user.getId());
                userToSave.setCommand(saved.getId());
                userRepository.save(userToSave);
            });

            return new ResponseEntity(commandRepository.findOne(saved.getId()), HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}