package br.com.myvet.mapper;

import br.com.myvet.domain.User;
import br.com.myvet.domain.Vet;
import br.com.myvet.dto.vet.VetCreationRequestDto;
import br.com.myvet.dto.vet.VetSearchingResponseDto;
import br.com.myvet.dto.vet.VetSearchingScheduleResponseDto;
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

    public VetSearchingResponseDto mapToVetSearchingResponseDto(Vet vet) {
        return VetSearchingResponseDto.builder()
                .name(vet.getName())
                .email(vet.getEmail())
                .photoUrl(vet.getPhotoUrl())
                .crmv(vet.getCrmv())
                .career(vet.getCareer())
                .type(vet.getType())
                .build();
    }
}
