package br.com.myvet.mapper;

import br.com.myvet.domain.User;
import br.com.myvet.domain.Vet;
import br.com.myvet.dto.user.UserCheckingResponseDto;
import br.com.myvet.dto.vet.VetSearchingScheduleResponseDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserCheckingResponseDto mapToUserCheckingResponseDto(User user) {
        return UserCheckingResponseDto.builder()
                .exists(true)
                .id(user.getId())
                .userType(user.getType())
                .build();
    }

    public VetSearchingScheduleResponseDto mapToVetSearchingScheduleResponseDto(Vet vet, Double grade) {
        return VetSearchingScheduleResponseDto.builder()
                .name(vet.getName())
                .id(vet.getId())
                .photoUrl(vet.getPhotoUrl())
                .email(vet.getEmail())
                .crmv(vet.getCrmv())
                .grade(grade)
                .career(vet.getCareer())
                .build();
    }
}
