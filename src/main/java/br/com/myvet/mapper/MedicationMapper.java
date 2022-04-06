package br.com.myvet.mapper;

import br.com.myvet.domain.Medication;
import br.com.myvet.domain.Pet;
import br.com.myvet.domain.User;
import br.com.myvet.dto.medication.MedicationCreationResponseDto;
import br.com.myvet.dto.medication.MedicationSearchingResponseDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MedicationMapper {

    public MedicationSearchingResponseDto mapToMedicationSearchingResponseDto(Medication medication) {
        return MedicationSearchingResponseDto.builder()
                .id(medication.getId())
                .type(medication.getType())
                .description(medication.getDescription())
                .build();
    }

    public Medication mapFromMedicationCreationResponseDto(User customer, Pet pet, MedicationCreationResponseDto responseDto) {
        return Medication.builder()
                .pet(pet)
                .customer(customer)
                .type(responseDto.getType())
                .description(responseDto.getDescription())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }
}
