package br.com.myvet.service.vet;

import br.com.myvet.domain.Vet;
import br.com.myvet.dto.user.UserCreationResponseDto;
import br.com.myvet.dto.vet.VetCreationRequestDto;
import br.com.myvet.dto.vet.VetSearchResponseDto;

public interface VetService {

    UserCreationResponseDto registerVet(VetCreationRequestDto requestDto);

    VetSearchResponseDto search(Vet vet);

}
