package br.com.myvet.controller;

import br.com.myvet.dto.scheduler.SchedulerCreationRequestDto;
import br.com.myvet.dto.scheduler.SchedulerSearchingResponseDto;
import br.com.myvet.dto.vet.VetSearchingScheduleResponseDto;
import br.com.myvet.enumeration.TurnType;
import br.com.myvet.service.scheduler.SchedulerService;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/schedulers")
public class SchedulerController {

    private final SchedulerService service;

    @PostMapping
    public void create(@RequestBody SchedulerCreationRequestDto requestDto) {
        service.create(requestDto);
    }

    @GetMapping
    public List<SchedulerSearchingResponseDto> search(@RequestParam(name = "userId") Long userId) {
        return service.search(userId);
    }

    @GetMapping("/vets")
    public List<VetSearchingScheduleResponseDto> search(@RequestParam(name = "userId") Long userId,
                                                        @RequestParam(name = "fromTime") String fromTime,
                                                        @RequestParam(name = "toTime") String toTime,
                                                        @RequestParam(name = "turn") TurnType turn,
                                                        @RequestParam(name = "date") String date) {
        return service.search(userId, fromTime, toTime, turn, date);
    }
}
