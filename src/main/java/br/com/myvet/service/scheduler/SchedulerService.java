package br.com.myvet.service.scheduler;

import br.com.myvet.dto.scheduler.SchedulerCreationRequestDto;
import br.com.myvet.dto.scheduler.SchedulerSearchingResponseDto;

import java.util.List;

public interface SchedulerService {

    void create(SchedulerCreationRequestDto requestDto);

    List<SchedulerSearchingResponseDto> search(Long userId);

}
