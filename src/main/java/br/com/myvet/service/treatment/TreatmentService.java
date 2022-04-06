package br.com.myvet.service.treatment;

import br.com.myvet.domain.Attendance;
import br.com.myvet.dto.treatment.TreatmentSearchingResponseDto;

import java.util.List;

public interface TreatmentService {

    void create(Attendance attendance, String period, String description);

    List<TreatmentSearchingResponseDto> search(List<Attendance> attendance);

}
