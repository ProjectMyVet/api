package br.com.myvet.service.customer;

import br.com.myvet.domain.Customer;
import br.com.myvet.dto.customer.CustomerCreationRequestDto;
import br.com.myvet.dto.customer.CustomerSearchingResponseDto;
import br.com.myvet.dto.user.UserCreationResponseDto;

public interface CustomerService {

    UserCreationResponseDto registerCustomer(CustomerCreationRequestDto requestDto);

    Customer findById(Long id);

}
