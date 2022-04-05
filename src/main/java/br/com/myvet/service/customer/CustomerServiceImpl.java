package br.com.myvet.service.customer;

import br.com.myvet.domain.Customer;
import br.com.myvet.domain.Vet;
import br.com.myvet.dto.customer.CustomerCreationRequestDto;
import br.com.myvet.dto.customer.CustomerSearchResponseDto;
import br.com.myvet.dto.user.UserCreationResponseDto;
import br.com.myvet.exception.NotFoundException;
import br.com.myvet.mapper.CustomerMapper;
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

    @Override
    public CustomerSearchResponseDto search(Customer customer) {
        return mapper.mapToCustomerSearchResponseDto(customer);
    }

    @Override
    public Customer findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new NotFoundException("Usuário não encontrado"));
    }
}
