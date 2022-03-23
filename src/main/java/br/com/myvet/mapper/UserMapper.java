package br.com.myvet.mapper;

import br.com.myvet.domain.User;
import br.com.myvet.dto.user.UserCheckingResponseDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserCheckingResponseDto mapToUserCheckingResponseDto(User user) {
        return UserCheckingResponseDto.builder()
                .exists(true)
                .id(user.getId())
                .userType(user.getType())
                .build();
    }
}
