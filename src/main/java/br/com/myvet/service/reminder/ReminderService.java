package br.com.myvet.service.reminder;

import br.com.myvet.dto.reminder.ReminderCreationRequestDto;
import br.com.myvet.dto.reminder.ReminderEditionRequestDto;
import br.com.myvet.dto.reminder.ReminderSearchingResponseDto;

import java.util.List;

public interface ReminderService {

    List<ReminderSearchingResponseDto> searchByUserId(Long userId);

    void create(ReminderCreationRequestDto requestDto);

    void edit(Long userId, ReminderEditionRequestDto requestDto);

}
