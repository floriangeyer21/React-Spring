package recat.spring.example.demo.security;


import org.springframework.stereotype.Service;
import recat.spring.example.demo.domain.entity.User;
import recat.spring.example.demo.service.interfaces.UserService;

import java.util.Set;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;

    public AuthenticationServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public User register(String email, String password) {
        User user = User.builder()
                .email(email)
                .password(password)
                .build();
        user = userService.saveUser(user);
        return user;
    }
}
