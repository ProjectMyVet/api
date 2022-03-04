package br.com.myvet.service.user;

import br.com.myvet.dto.user.UserCheckingResponseDto;

public interface UserService {

    UserCheckingResponseDto checkExistsByIdToken(String idToken);

}
