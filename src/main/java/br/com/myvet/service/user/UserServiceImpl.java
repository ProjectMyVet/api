package br.com.myvet.service.user;

import br.com.myvet.dto.user.UserCheckingResponseDto;
import br.com.myvet.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public UserCheckingResponseDto checkExistsByIdToken(String idToken) {
        final var exists = repository.existsByIdToken(idToken);
        return new UserCheckingResponseDto(exists);
    }
}
