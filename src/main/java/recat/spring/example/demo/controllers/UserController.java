package recat.spring.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import recat.spring.example.demo.domain.dto.UserDto;
import recat.spring.example.demo.domain.entity.User;
import recat.spring.example.demo.service.impl.UserServiceImpl;
import recat.spring.example.demo.service.mappers.UserMapper;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserServiceImpl userServiceImpl;
    private UserMapper userMapper;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl, UserMapper userMapper) {
        this.userServiceImpl = userServiceImpl;
        this.userMapper = userMapper;
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id) {
        return userMapper.mapUserToDto(userServiceImpl.getUserById(id));
    }

    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDto) {
        User user = userMapper.mapDtoToUser(userDto);
        return userMapper.mapUserToDto(userServiceImpl.saveUser(user));
    }

    @GetMapping
    public List<UserDto> getAllUsers() {
        return userServiceImpl.getAllUsers()
                .stream()
                .map(user -> userMapper.mapUserToDto(user))
                .collect(Collectors.toList());
    }
}
