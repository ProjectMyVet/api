package br.com.myvet.controller;

import br.com.myvet.dto.customer.CustomerCreationRequestDto;
import br.com.myvet.dto.vet.VetCreationRequestDto;
import br.com.myvet.service.customer.CustomerService;
import br.com.myvet.service.vet.VetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final CustomerService customerService;

    private final VetService vetService;

    @PostMapping("/customer")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerCustomer(@RequestBody CustomerCreationRequestDto requestDto) {
        customerService.registerCustomer(requestDto);
    }

    @PostMapping("/vet")
    @ResponseStatus(HttpStatus.CREATED)
    public void registerVet(@RequestBody VetCreationRequestDto requestDto) {
        vetService.registerVet(requestDto);
    }
}
