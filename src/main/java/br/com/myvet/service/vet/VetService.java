package br.com.myvet.service.vet;

import br.com.myvet.dto.user.UserCreationResponseDto;
import br.com.myvet.dto.vet.VetCreationRequestDto;

public interface VetService {

    UserCreationResponseDto registerVet(VetCreationRequestDto requestDto);

}
