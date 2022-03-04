package br.com.myvet.service.customer;

import br.com.myvet.dto.customer.CustomerCreationRequestDto;

public interface CustomerService {

    void registerCustomer(CustomerCreationRequestDto requestDto);

}
