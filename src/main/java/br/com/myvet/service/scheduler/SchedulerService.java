package br.com.myvet.service.scheduler;

import br.com.myvet.domain.Schedule;
import br.com.myvet.dto.scheduler.SchedulerCreationRequestDto;
import br.com.myvet.dto.scheduler.SchedulerSearchingResponseDto;
import br.com.myvet.dto.vet.VetSearchingScheduleResponseDto;
import br.com.myvet.enumeration.TurnType;

import java.time.LocalDate;
import java.util.List;

public interface SchedulerService {

    void create(SchedulerCreationRequestDto requestDto);

    List<SchedulerSearchingResponseDto> search(Long userId);

    List<Schedule> search(String fromTime, String toTime, TurnType turnType, LocalDate date);

    List<VetSearchingScheduleResponseDto> search(Long userId, String fromTime, String toTime, TurnType turnType, String date);

}
