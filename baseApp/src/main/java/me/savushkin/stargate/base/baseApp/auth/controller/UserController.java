package me.savushkin.stargate.base.baseApp.auth.controller;

import me.savushkin.stargate.base.baseApp.auth.model.User;
import me.savushkin.stargate.base.baseApp.auth.model.UserRole;
import me.savushkin.stargate.base.baseApp.auth.repository.UserRepository;
import me.savushkin.stargate.base.baseApp.auth.repository.UserRoleRepository;
import me.savushkin.stargate.base.baseApp.command.repository.CommandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.List;

@Controller
@RequestMapping("/api/user")
public class UserController {
    private final UserRepository userRepository;
    private final CommandRepository commandRepository;
    private final UserRoleRepository userRoleRepository;

    @Autowired
    public UserController(UserRepository userRepository,
                          CommandRepository commandRepository,
                          UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.commandRepository = commandRepository;
        this.userRoleRepository = userRoleRepository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity getPage(
            @RequestParam(name = "page", defaultValue = "0") Integer pageNum,
            @RequestParam(name = "size", defaultValue = "15") Integer size) {
        try {
            Page<User> page = userRepository.findAll(new PageRequest(pageNum, size));
            return new ResponseEntity(page, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public ResponseEntity getUser(
            @PathVariable @NotNull Long id) {
        try {
            User user = userRepository.findOne(id);
            return new ResponseEntity(user, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity create(
            @RequestParam() String username,
            @RequestParam() String name,
            @RequestParam() String secondName,
            @RequestParam() String surname,
            @RequestParam() String rank,
            @RequestParam() String password,
            @RequestParam() Boolean isEnabled,
            @RequestParam() Long commandId,
            @RequestParam() List<String> userRoles){
        try{
            User newUser = new User();
            newUser.setUsername(username);
            newUser.setName(name);
            newUser.setSecondName(secondName);
            newUser.setSurname(surname);
            newUser.setRank(rank);
            //TODO: не знаю, как хешировать пароль
            newUser.setPassword(password);
            newUser.setEnabled(isEnabled);
            //TODO:раскомментировать, когда появятся команды
//            newUser.setCommand(commandRepository.findOne(commandId));

            
            newUser = userRepository.save(newUser);

            for (String s:
                 userRoles) {
                UserRole role = new UserRole();
                role.setRole(s);
                role.setUser(newUser.getId());
                userRoleRepository.save(role);
            }
            return new ResponseEntity(userRepository.findOne(newUser.getId()), HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    //TODO:нужно разрешить метод DELETE
    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        try {
            userRepository.delete(id);
            return new ResponseEntity("ok", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public ResponseEntity update(@RequestParam() Long id,
                                 @RequestParam() String username,
                                 @RequestParam() String name,
                                 @RequestParam() String secondName,
                                 @RequestParam() String surname,
                                 @RequestParam() String rank,
                                 @RequestParam() Boolean isEnabled,
                                 @RequestParam() Long commandId,
                                 @RequestParam() List<String> userRoles){
        try {
            User user = userRepository.findOne(id);
            if(user == null)
                return new ResponseEntity(HttpStatus.BAD_REQUEST);

            user.setUsername(username);
            user.setName(name);
            user.setSecondName(secondName);
            user.setSurname(surname);
            user.setRank(rank);
            user.setEnabled(isEnabled);
            //TODO:раскомментировать, когда появятся команды
//            newUser.setCommand(commandRepository.findOne(commandId));

            user = userRepository.save(user);

            List<UserRole> roles = userRoleRepository.findByUser(user.getId());

            userRoleRepository.delete(roles);

            for (String s:
                    userRoles) {
                UserRole role = new UserRole();
                role.setRole(s);
                role.setUser(user.getId());
                userRoleRepository.save(role);
            }

            return new ResponseEntity(userRepository.findOne(user.getId()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}