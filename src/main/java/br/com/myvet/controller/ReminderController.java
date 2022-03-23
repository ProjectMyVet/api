package br.com.myvet.controller;

import br.com.myvet.dto.reminder.ReminderCreationRequestDto;
import br.com.myvet.dto.reminder.ReminderEditionRequestDto;
import br.com.myvet.dto.reminder.ReminderSearchingResponseDto;
import br.com.myvet.service.reminder.ReminderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reminders")
public class ReminderController {

    private final ReminderService reminderService;

    @GetMapping
    public List<ReminderSearchingResponseDto> search(@RequestParam(name = "userId") Long userId) {
        return reminderService.searchByUserId(userId);
    }

    @PostMapping
    public void create(@RequestBody ReminderCreationRequestDto requestDto) {
        reminderService.create(requestDto);
    }

    @PutMapping
    public void edit(@RequestParam(name = "userId") Long userId, @RequestBody ReminderEditionRequestDto requestDto) {
        reminderService.edit(userId, requestDto);
    }
}
