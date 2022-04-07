package br.com.myvet.service.evaluation;

import br.com.myvet.domain.Attendance;
import br.com.myvet.domain.Evaluation;
import br.com.myvet.dto.evaluation.EvaluationCreationRequestDto;
import br.com.myvet.mapper.EvaluationMapper;
import br.com.myvet.repository.EvaluationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EvaluationServiceImpl implements EvaluationService {

    private final EvaluationRepository repository;

    private final EvaluationMapper mapper;

    @Override
    public void create(Attendance attendance, EvaluationCreationRequestDto requestDto) {
        final var evaluation = mapper.mapFromEvaluationCreationRequestDto(attendance, requestDto);
        repository.save(evaluation);
    }

    @Override
    public Double searchGradeAverageByAttendances(List<Attendance> attendances) {
        final List<Evaluation> evaluations = repository.findByAttendanceIn(attendances);
        return evaluations.stream()
                .mapToDouble(Evaluation::getGrade)
                .average()
                .orElse(5D);
    }
}
