package br.com.myvet.mapper;

import br.com.myvet.domain.Schedule;
import br.com.myvet.domain.Vet;
import br.com.myvet.dto.scheduler.SchedulerCreationDateRequestDto;
import br.com.myvet.dto.scheduler.SchedulerSearchingResponseDto;
import br.com.myvet.enumeration.TurnType;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class SchedulerMapper {

    public Schedule mapFromSchedulerCreationDateRequestDto(TurnType turnType, Vet vet, SchedulerCreationDateRequestDto requestDto) {
        return Schedule.builder()
                .toTime(requestDto.getToTime())
                .fromTime(requestDto.getFromTime())
                .dayOfWeek(requestDto.getDayOfWeek())
                .vet(vet)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .turn(turnType)
                .build();
    }

    public SchedulerSearchingResponseDto mapToSchedulerSearchingResponseDto(Schedule schedule) {
        return SchedulerSearchingResponseDto.builder()
                .id(schedule.getId())
                .fromTime(schedule.getFromTime())
                .dayOfWeek(schedule.getDayOfWeek())
                .toTime(schedule.getToTime())
                .turn(schedule.getTurn())
                .build();
    }
}
