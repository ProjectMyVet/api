package br.com.myvet.service.pet;

import br.com.myvet.dto.pet.PetCreationRequestDto;
import br.com.myvet.dto.pet.PetSearchingResponseDto;

import java.util.List;

public interface PetService {

    void registerPet(PetCreationRequestDto requestDto);

    List<PetSearchingResponseDto> search(Long userId);

}
