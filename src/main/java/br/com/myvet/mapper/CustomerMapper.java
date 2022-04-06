package br.com.myvet.mapper;

import br.com.myvet.domain.Customer;
import br.com.myvet.dto.customer.CustomerCreationRequestDto;
import br.com.myvet.dto.customer.CustomerSearchingResponseDto;
import br.com.myvet.enumeration.UserType;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class CustomerMapper {

    public Customer mapToCustomer(CustomerCreationRequestDto requestDto) {
        return Customer.builder()
                .idToken(requestDto.getIdToken())
                .name(requestDto.getName())
                .email(requestDto.getEmail())
                .photoUrl(requestDto.getPhotoUrl())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .bio(requestDto.getBio())
                .type(UserType.CUSTOMER)
                .build();
    }

    public CustomerSearchingResponseDto mapToCustomerSearchResponseDto(Customer customer, Long attendances, Long pets) {
        return CustomerSearchingResponseDto.builder()
                .name(customer.getName())
                .email(customer.getEmail())
                .photoUrl(customer.getPhotoUrl())
                .bio(customer.getBio())
                .type(customer.getType())
                .quantityAttendance(attendances)
                .quantityPet(pets)
                .build();
    }
}
