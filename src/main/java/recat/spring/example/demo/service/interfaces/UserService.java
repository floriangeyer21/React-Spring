package recat.spring.example.demo.service.interfaces;

import recat.spring.example.demo.domain.entity.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);

    User getUserById(Long id);

    List<User> getAllUsers();
}
