package br.com.brunocontentedev.auth.controller;

import br.com.brunocontentedev.auth.dto.request.UserRegisterDTO;
import br.com.brunocontentedev.auth.dto.response.UserResponseDTO;
import br.com.brunocontentedev.auth.exception.UserAlreadyExistsException;
import br.com.brunocontentedev.auth.service.UserService;
import jakarta.validation.Valid;
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
    public UserResponseDTO saveUser(@RequestBody @Valid UserRegisterDTO userDTO) throws UserAlreadyExistsException {
        return userService.save(userDTO);
    }
}
