package br.com.myvet.service.user;

import br.com.myvet.domain.User;
import br.com.myvet.dto.user.UserCheckingResponseDto;

public interface UserService {

    UserCheckingResponseDto checkExistsByIdToken(String idToken);

    User findByIdOrElseThrow(Long userId);

}
