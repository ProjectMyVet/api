package br.com.myvet.service.evaluation;

import br.com.myvet.domain.Attendance;
import br.com.myvet.dto.evaluation.EvaluationCreationRequestDto;

import java.util.List;

public interface EvaluationService {

    void create(Attendance attendance, EvaluationCreationRequestDto requestDto);

    Double searchGradeAverageByAttendances(List<Attendance> attendances);

}
