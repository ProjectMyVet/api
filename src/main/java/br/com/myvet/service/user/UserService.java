package br.com.myvet.service.user;

import br.com.myvet.domain.Customer;
import br.com.myvet.domain.User;
import br.com.myvet.domain.Vet;
import br.com.myvet.dto.user.UserCheckingResponseDto;

public interface UserService {

    UserCheckingResponseDto checkExistsByIdToken(String idToken);

    User findByIdOrElseThrow(Long userId);

    Vet findVetById(Long userId);

    Customer findCustomerById(Long userId);

}
