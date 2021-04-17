package recat.spring.example.demo.security;


import recat.spring.example.demo.domain.entity.User;

public interface AuthenticationService {

    User register(String email, String password);
}
