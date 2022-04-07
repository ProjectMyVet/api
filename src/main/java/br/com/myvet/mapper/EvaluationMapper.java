package br.com.myvet.mapper;

import br.com.myvet.domain.Attendance;
import br.com.myvet.domain.Evaluation;
import br.com.myvet.dto.evaluation.EvaluationCreationRequestDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class EvaluationMapper {

    public Evaluation mapFromEvaluationCreationRequestDto(Attendance attendance, EvaluationCreationRequestDto requestDto) {
        return Evaluation.builder()
                .attendance(attendance)
                .grade(requestDto.getGrade())
                .description(requestDto.getDescription())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }
}
