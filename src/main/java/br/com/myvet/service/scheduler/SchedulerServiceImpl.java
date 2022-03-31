package br.com.myvet.service.scheduler;

import br.com.myvet.dto.scheduler.SchedulerCreationDateRequestDto;
import br.com.myvet.dto.scheduler.SchedulerCreationRequestDto;
import br.com.myvet.dto.scheduler.SchedulerSearchingResponseDto;
import br.com.myvet.mapper.SchedulerMapper;
import br.com.myvet.repository.SchedulerRepository;
import br.com.myvet.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SchedulerServiceImpl implements SchedulerService {

    private final SchedulerRepository repository;

    private final UserService userService;

    private final SchedulerMapper mapper;

    @Override
    @Transactional
    public void create(SchedulerCreationRequestDto requestDto) {
        final var user = userService.findByIdOrElseThrow(requestDto.getUserId());
        repository.deleteByUserAndTurn(user, requestDto.getTurn());
        final List<SchedulerCreationDateRequestDto> scheduler = requestDto.getDates().stream()
                .filter(SchedulerCreationDateRequestDto::isChecked)
                .collect(Collectors.toList());
        repository.saveAll(scheduler.stream()
                .map(item -> mapper.mapFromSchedulerCreationDateRequestDto(requestDto.getTurn(), user, item))
                .collect(Collectors.toList()));
    }

    @Override
    public List<SchedulerSearchingResponseDto> search(Long userId) {
        final var user = userService.findByIdOrElseThrow(userId);
        return repository.findByUser(user).stream()
                .map(mapper::mapToSchedulerSearchingResponseDto)
                .collect(Collectors.toList());
    }
}
