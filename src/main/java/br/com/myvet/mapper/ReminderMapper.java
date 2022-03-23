package br.com.myvet.mapper;

import br.com.myvet.domain.Reminder;
import br.com.myvet.domain.User;
import br.com.myvet.dto.reminder.ReminderCreationRequestDto;
import br.com.myvet.dto.reminder.ReminderEditionRequestDto;
import br.com.myvet.dto.reminder.ReminderSearchingResponseDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ReminderMapper {

    public ReminderSearchingResponseDto mapToReminderSearchingResponseDto(Reminder reminder) {
        return ReminderSearchingResponseDto.builder()
                .id(reminder.getId())
                .action(reminder.getAction())
                .date(reminder.getDate())
                .build();
    }

    public Reminder mapFromReminderCreationRequestDto(ReminderCreationRequestDto requestDto, User user) {
        return Reminder.builder()
                .action(requestDto.getAction())
                .date(requestDto.getDate())
                .user(user)
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    public void mapFromReminderEditionRequestDto(Reminder reminder, ReminderEditionRequestDto requestDto) {
        reminder.setDate(re);
    }
}
