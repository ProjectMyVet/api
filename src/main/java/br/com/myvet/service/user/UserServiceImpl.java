package br.com.myvet.service.user;

import br.com.myvet.domain.Customer;
import br.com.myvet.domain.User;
import br.com.myvet.domain.Vet;
import br.com.myvet.dto.user.UserCheckingResponseDto;
import br.com.myvet.exception.NotFoundException;
import br.com.myvet.mapper.UserMapper;
import br.com.myvet.repository.UserRepository;
import br.com.myvet.service.customer.CustomerService;
import br.com.myvet.service.vet.VetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static br.com.myvet.enumeration.UserType.CUSTOMER;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final CustomerService customerService;

    private final UserRepository repository;

    private final UserMapper userMapper;

    private final VetService vetService;

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

    @Override
    public Object findObjectById(Long userId) {
        final User user = findByIdOrElseThrow(userId);
        if (CUSTOMER.equals(user.getType())) {
            return customerService.search((Customer) user);
        } else {
            return vetService.search((Vet) user);
        }
    }

    @Override
    public Vet findVetById(Long userId) {
        return vetService.findById(userId);
    }

    @Override
    public Customer findCustomerById(Long userId) {
        return customerService.findById(userId);
    }
}
