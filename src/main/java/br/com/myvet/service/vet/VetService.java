package br.com.myvet.service.vet;

import br.com.myvet.domain.Vet;
import br.com.myvet.dto.user.UserCreationResponseDto;
import br.com.myvet.dto.vet.VetCreationRequestDto;
import br.com.myvet.dto.vet.VetSearchingResponseDto;

public interface VetService {

    UserCreationResponseDto registerVet(VetCreationRequestDto requestDto);

    VetSearchingResponseDto search(Vet vet);

    Vet findById(Long id);

}
