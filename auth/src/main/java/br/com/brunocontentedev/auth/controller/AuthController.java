package br.com.brunocontentedev.auth.controller;

import br.com.brunocontentedev.auth.dto.response.LoginResponseDTO;
import br.com.brunocontentedev.auth.dto.request.LoginResquestDTO;
import br.com.brunocontentedev.auth.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("login")
    @ResponseStatus(HttpStatus.OK)
    public LoginResponseDTO login(@RequestBody LoginResquestDTO loginResquestDTO){
        return authService.login(loginResquestDTO);

    }
}
