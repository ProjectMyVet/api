package br.com.myvet.service.scheduler;

import br.com.myvet.domain.Schedule;
import br.com.myvet.domain.Vet;
import br.com.myvet.dto.scheduler.SchedulerCreationDateRequestDto;
import br.com.myvet.dto.scheduler.SchedulerCreationRequestDto;
import br.com.myvet.dto.scheduler.SchedulerSearchingResponseDto;
import br.com.myvet.dto.vet.VetSearchingScheduleResponseDto;
import br.com.myvet.enumeration.TurnType;
import br.com.myvet.mapper.SchedulerMapper;
import br.com.myvet.mapper.UserMapper;
import br.com.myvet.repository.SchedulerRepository;
import br.com.myvet.service.attendance.AttendanceService;
import br.com.myvet.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SchedulerServiceImpl implements SchedulerService {

    private final AttendanceService attendanceService;

    private final SchedulerRepository repository;

    private final UserService userService;

    private final SchedulerMapper mapper;

    private final UserMapper userMapper;

    @Override
    @Transactional
    public void create(SchedulerCreationRequestDto requestDto) {
        final Vet vet = userService.findVetById(requestDto.getUserId());
        repository.deleteByVetAndTurn(vet, requestDto.getTurn());
        final List<SchedulerCreationDateRequestDto> scheduler = requestDto.getDates().stream()
                .filter(SchedulerCreationDateRequestDto::isChecked)
                .collect(Collectors.toList());
        repository.saveAll(scheduler.stream()
                .map(item -> mapper.mapFromSchedulerCreationDateRequestDto(requestDto.getTurn(), vet, item))
                .collect(Collectors.toList()));
    }

    @Override
    public List<SchedulerSearchingResponseDto> search(Long userId) {
        final Vet vet = userService.findVetById(userId);
        return repository.findByVet(vet).stream()
                .map(mapper::mapToSchedulerSearchingResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<Schedule> search(String fromTime, String toTime, TurnType turnType, LocalDate date) {
        return repository.findByFromTimeAndToTimeAndTurnAndDayOfWeek(fromTime, toTime, turnType, date.getDayOfWeek().getValue());
    }

    @Override
    public List<VetSearchingScheduleResponseDto> search(Long userId, String fromTime, String toTime, TurnType turnType, String date) {
        //TODO add geolocation to filter
        //TODO return evaluation
        final var formattedDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        final List<VetSearchingScheduleResponseDto> response = new ArrayList<>();
        final List<Vet> vets = repository.findByFromTimeAndToTimeAndTurnAndDayOfWeek(fromTime, toTime, turnType, formattedDate.getDayOfWeek().getValue()).stream()
                .map(Schedule::getVet)
                .collect(Collectors.toList());
        vets.forEach(vet -> {
            if (!attendanceService.check(vet, fromTime, toTime, turnType, formattedDate)) {
                response.add(userMapper.mapToVetSearchingScheduleResponseDto(vet));
            }
        });
        return response;
    }
}
