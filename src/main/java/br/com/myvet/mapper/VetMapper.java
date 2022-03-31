package br.com.myvet.mapper;

import br.com.myvet.domain.Vet;
import br.com.myvet.dto.vet.VetCreationRequestDto;
import br.com.myvet.dto.vet.VetSearchResponseDto;
import br.com.myvet.enumeration.UserType;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class VetMapper {

    public Vet mapToVet(VetCreationRequestDto requestDto) {
        return Vet.builder()
                .idToken(requestDto.getIdToken())
                .name(requestDto.getName())
                .email(requestDto.getEmail())
                .photoUrl(requestDto.getPhotoUrl())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .career(requestDto.getCareer())
                .crmv(requestDto.getCrmv())
                .type(UserType.VET)
                .build();
    }

    public VetSearchResponseDto mapToVetSearchResponseDto(Vet vet) {
        return VetSearchResponseDto.builder()
                .name(vet.getName())
                .email(vet.getEmail())
                .photoUrl(vet.getPhotoUrl())
                .crmv(vet.getCrmv())
                .career(vet.getCareer())
                .type(vet.getType())
                .build();
    }
}
