package br.com.myvet.service.customer;

import br.com.myvet.dto.customer.CustomerCreationRequestDto;
import br.com.myvet.dto.user.UserCreationResponseDto;
import br.com.myvet.mapper.customer.CustomerMapper;
import br.com.myvet.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    private final CustomerMapper mapper;

    @Override
    public UserCreationResponseDto registerCustomer(CustomerCreationRequestDto requestDto) {
        final var customer = mapper.mapToCustomer(requestDto);
        return new UserCreationResponseDto(repository.save(customer).getId());
    }
}
