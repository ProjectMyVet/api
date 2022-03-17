package br.com.myvet.mapper.pet;

import br.com.myvet.domain.Pet;
import br.com.myvet.domain.User;
import br.com.myvet.dto.pet.PetCreationRequestDto;
import br.com.myvet.dto.pet.PetSearchingResponseDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PetMapper {

    public Pet mapFromPetCreationRequestDto(User user, PetCreationRequestDto requestDto) {
        return Pet.builder()
                .user(user)
                .name(requestDto.getName())
                .breed(requestDto.getBreed())
                .birthDate(requestDto.getBirthDate())
                .type(requestDto.getType())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    public PetSearchingResponseDto mapToPetSearchingResponseDto(Pet pet) {
        return PetSearchingResponseDto.builder()
                .id(pet.getId())
                .birthDate(pet.getBirthDate())
                .breed(pet.getBreed())
                .name(pet.getName())
                .type(pet.getType())
                .build();
    }
}
