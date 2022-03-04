package br.com.myvet.service.vet;

import br.com.myvet.dto.vet.VetCreationRequestDto;

public interface VetService {

    void registerVet(VetCreationRequestDto requestDto);

}
