package com.jardessouza.bookstoremanager.user.controller;

import com.jardessouza.bookstoremanager.user.dto.JwtRequest;
import com.jardessouza.bookstoremanager.user.dto.JwtResponse;
import com.jardessouza.bookstoremanager.user.dto.UserDTO;
import com.jardessouza.bookstoremanager.user.service.AuthenticationService;
import com.jardessouza.bookstoremanager.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController implements UserControllerDocs {

    private final UserService userService;
    private final AuthenticationService authenticationService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> findAll() {
        return this.userService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO create(@RequestBody @Valid UserDTO userDTO) {
        return userService.create(userDTO);
    }

    @GetMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping(path = "/find")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> findByName(@RequestParam String name) {
        return userService.findByName(name);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void replace(@RequestBody @Valid UserDTO userDTO) {
        userService.update(userDTO);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
    @PostMapping(value = "/authenticate")
    public JwtResponse createAuthenticationToken(@RequestBody @Valid JwtRequest jwtRequest) {
        return authenticationService.createAuthenticationToken(jwtRequest);
    }
}
