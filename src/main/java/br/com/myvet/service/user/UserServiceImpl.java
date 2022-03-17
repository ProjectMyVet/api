package br.com.myvet.service.user;

import br.com.myvet.domain.User;
import br.com.myvet.dto.user.UserCheckingResponseDto;
import br.com.myvet.exception.NotFoundException;
import br.com.myvet.mapper.user.UserMapper;
import br.com.myvet.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    private final UserMapper userMapper;

    @Override
    public UserCheckingResponseDto checkExistsByIdToken(String idToken) {
        return repository.findByIdToken(idToken)
                .map(userMapper::mapToUserCheckingResponseDto)
            .orElseThrow(() -> new NotFoundException("Usuário não encontrado")); //TODO criar message service
    }

    @Override
    public User findByIdOrElseThrow(Long userId) {
        return repository.findById(userId)
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado"));
    }
}
