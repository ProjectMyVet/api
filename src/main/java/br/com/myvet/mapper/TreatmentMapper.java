package br.com.myvet.mapper;

import br.com.myvet.domain.Attendance;
import br.com.myvet.domain.Treatment;
import br.com.myvet.dto.treatment.TreatmentSearchingResponseDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TreatmentMapper {

    public Treatment mapFromCreation(Attendance attendance, String period, String description) {
        return Treatment.builder()
                .attendance(attendance)
                .period(period)
                .description(description)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    public TreatmentSearchingResponseDto mapToTreatmentSearchingResponseDto(Treatment treatment) {
        return TreatmentSearchingResponseDto.builder()
                .id(treatment.getId())
                .period(treatment.getPeriod())
                .description(treatment.getDescription())
                .build();
    }
}
