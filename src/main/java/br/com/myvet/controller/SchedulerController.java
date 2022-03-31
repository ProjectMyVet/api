package br.com.myvet.controller;

import br.com.myvet.dto.scheduler.SchedulerCreationRequestDto;
import br.com.myvet.dto.scheduler.SchedulerSearchingResponseDto;
import br.com.myvet.service.scheduler.SchedulerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
}
