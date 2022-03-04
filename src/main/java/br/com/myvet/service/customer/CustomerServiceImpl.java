package br.com.myvet.service.customer;

import br.com.myvet.dto.customer.CustomerCreationRequestDto;
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
    public void registerCustomer(CustomerCreationRequestDto requestDto) {
        final var customer = mapper.mapToCustomer(requestDto);
        repository.save(customer);
    }
}
