package br.com.myvet.service.reminder;

import br.com.myvet.dto.reminder.ReminderCreationRequestDto;
import br.com.myvet.dto.reminder.ReminderEditionRequestDto;
import br.com.myvet.dto.reminder.ReminderSearchingResponseDto;
import br.com.myvet.mapper.ReminderMapper;
import br.com.myvet.repository.ReminderRepository;
import br.com.myvet.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReminderServiceImpl implements ReminderService {

    private final ReminderRepository repository;

    private final UserService userService;

    private final ReminderMapper mapper;

    @Override
    public List<ReminderSearchingResponseDto> searchByUserId(Long userId) {
        final var user = userService.findByIdOrElseThrow(userId);
        return repository.findByUser(user).stream()
                .map(mapper::mapToReminderSearchingResponseDto)
                .collect(Collectors.toList());
    }

    @Override
    public void create(ReminderCreationRequestDto requestDto) {
        final var user = userService.findByIdOrElseThrow(requestDto.getUserId());
        final var reminder = mapper.mapFromReminderCreationRequestDto(requestDto, user);
        repository.save(reminder);
    }

    @Override
    public void edit(Long userId, ReminderEditionRequestDto requestDto) {
        final var user = userService.findByIdOrElseThrow(userId);
        final var reminder = repository.findByIdAndUser(requestDto.getId(), user)
                .orElseThrow(() -> new RuntimeException("Lembrete não encontrado"));
        mapper.mapFromReminderEditionRequestDto(reminder, requestDto);
        repository.save(reminder);
    }
}
