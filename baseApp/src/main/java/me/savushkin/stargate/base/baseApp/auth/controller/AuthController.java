package me.savushkin.stargate.base.baseApp.auth.controller;

import me.savushkin.stargate.base.baseApp.auth.model.User;
import me.savushkin.stargate.base.baseApp.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;

    @Autowired
    public AuthController(
            @Qualifier("authenticationManager") AuthenticationManager authenticationManager,
            UserRepository userRepository) {
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
    }

    @RequestMapping(path="/login", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<?> login(
            @RequestParam("username") String username,
            @RequestParam("password") String password) {
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
        try {
            Authentication auth = authenticationManager.authenticate(token);
            SecurityContextHolder.getContext().setAuthentication(auth);
        } catch (BadCredentialsException e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        User user = userRepository.findByUsername(username);
        return new ResponseEntity(user, HttpStatus.OK);
    }

    @RequestMapping(path="/logout", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void logout(HttpSession session) {
        session.invalidate();
    }
}
