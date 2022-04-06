package br.com.myvet.service.treatment;

import br.com.myvet.domain.Attendance;
import br.com.myvet.dto.treatment.TreatmentSearchingResponseDto;
import br.com.myvet.mapper.TreatmentMapper;
import br.com.myvet.repository.TreatmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TreatmentServiceImpl implements TreatmentService {

    private final TreatmentRepository repository;

    private final TreatmentMapper mapper;

    @Override
    public void create(Attendance attendance, String period, String description) {
        final var treatment = mapper.mapFromCreation(attendance, period, description);
        repository.save(treatment);
    }

    @Override
    public List<TreatmentSearchingResponseDto> search(List<Attendance> attendance) {
        return repository.findByAttendanceIn(attendance).stream()
                .map(mapper::mapToTreatmentSearchingResponseDto)
                .collect(Collectors.toList());
    }
}
