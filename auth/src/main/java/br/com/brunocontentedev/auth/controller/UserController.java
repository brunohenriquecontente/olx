package br.com.brunocontentedev.auth.controller;

import br.com.brunocontentedev.auth.dto.UserDTO;
import br.com.brunocontentedev.auth.exception.UserAlreadyExistsException;
import br.com.brunocontentedev.auth.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {


    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO saveUser(@RequestBody UserDTO userDTO) throws UserAlreadyExistsException {
        return userService.save(userDTO);
    }
}
