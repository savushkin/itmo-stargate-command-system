package me.savushkin.stargate.base.baseApp.auth.controller;

import me.savushkin.stargate.base.baseApp.auth.configaration.WebSecurityConfig;
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
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/api/user")
public class UserController {
    private final UserRepository userRepository;
    private final CommandRepository commandRepository;
    private final UserRoleRepository userRoleRepository;
    private final String DEFAULT_PASS = new BCryptPasswordEncoder().encode("derparol");

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

    @RequestMapping(method = RequestMethod.POST, path = "/forCommand")
    public ResponseEntity getUsersForCommand(
            @RequestParam() @Null Long id
    ) {
        try {
            List<User> users;
            if(id == null){
                users = userRepository.findUsersForAddToCommand(WebSecurityConfig.ROLE_SG);
            }
            else{
                users = userRepository.findUsersForAddToCommand(WebSecurityConfig.ROLE_SG, id);
            }
            return new ResponseEntity(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity createUser(
            @RequestBody() User userData){
        try{
            userData.setPassword(DEFAULT_PASS);
            Set<UserRole> roles = userData.getUserRole();
            userData.setUserRole(null);
            User savedUser = userRepository.save(userData);
            roles.forEach(role -> role.setUser(savedUser.getId()));
            userRoleRepository.save(roles);
            return new ResponseEntity(userRepository.findOne(savedUser.getId()), HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        try {
            userRepository.delete(id);
            return new ResponseEntity(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public ResponseEntity update(
            @PathVariable @NotNull Long id,
            @RequestBody() User userData){
        try {
            User user = userRepository.findOne(id);
            if(user == null)
                return new ResponseEntity(HttpStatus.BAD_REQUEST);

            user.setPassword(DEFAULT_PASS);

            user.setEnabled(userData.isEnabled());
            user.setName(userData.getName());
            user.setRank(userData.getRank());
            user.setSecondName(userData.getSecondName());
            user.setSurname(userData.getSurname());
            user.setUsername(userData.getUsername());
            user.setCommand(userData.getCommand());

            Set<UserRole> roles = userData.getUserRole();
            userData.setUserRole(null);
            User savedUser = userRepository.save(user);
            roles.forEach(role -> {
                userRoleRepository.deleteAllByUser(savedUser.getId());
                role.setUser(savedUser.getId());
            });
            userRoleRepository.save(roles);

            return new ResponseEntity(userRepository.findOne(user.getId()), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}