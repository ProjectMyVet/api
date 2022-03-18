package br.com.myvet.service.pet;

import br.com.myvet.dto.pet.PetCreationRequestDto;
import br.com.myvet.dto.pet.PetEditionRequestDto;
import br.com.myvet.dto.pet.PetSearchingResponseDto;

import java.util.List;

public interface PetService {

    void register(PetCreationRequestDto requestDto);

    List<PetSearchingResponseDto> search(Long userId);

    void edit(Long userId, PetEditionRequestDto requestDto);

}
