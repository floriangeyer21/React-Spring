package recat.spring.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import recat.spring.example.demo.domain.dto.request.UserRequestDto;
import recat.spring.example.demo.domain.dto.response.UserResponseDto;
import recat.spring.example.demo.security.AuthenticationService;
import recat.spring.example.demo.service.mappers.UserMapper;

@RestController
@RequestMapping
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final UserMapper userMapper;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService,
                                    UserMapper userMapper) {
        this.authenticationService = authenticationService;
        this.userMapper = userMapper;
    }

    @PostMapping("/register")
    public UserResponseDto register(@RequestBody UserRequestDto userRequestDto) {
        String email = userRequestDto.getEmail();
        String password = userRequestDto.getPassword();
        return userMapper.mapUserToResponseDto(
                authenticationService.register(email, password));
    }
}