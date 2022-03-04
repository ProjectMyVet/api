package br.com.myvet.controller;

import br.com.myvet.dto.customer.CustomerCreationRequestDto;
import br.com.myvet.dto.user.UserCheckingResponseDto;
import br.com.myvet.dto.vet.VetCreationRequestDto;
import br.com.myvet.service.customer.CustomerService;
import br.com.myvet.service.user.UserService;
import br.com.myvet.service.vet.VetService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final CustomerService customerService;

    private final UserService userService;

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

    @GetMapping("/check")
    public UserCheckingResponseDto checkExists(@RequestParam(value = "idToken") @NotBlank @Size(max = 255) String idToken) {
        return userService.checkExistsByIdToken(idToken);
    }
}
