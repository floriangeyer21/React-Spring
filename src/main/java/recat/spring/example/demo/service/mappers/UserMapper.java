package recat.spring.example.demo.service.mappers;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import recat.spring.example.demo.domain.dto.response.UserResponseDto;
import recat.spring.example.demo.domain.entity.User;

@Component
@NoArgsConstructor
public class UserMapper {

    public UserResponseDto mapUserToResponseDto(User user) {
        return UserResponseDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .build();
    }
}
