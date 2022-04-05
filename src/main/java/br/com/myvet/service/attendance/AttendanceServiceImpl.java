package br.com.myvet.service.attendance;

import br.com.myvet.domain.Attendance;
import br.com.myvet.domain.User;
import br.com.myvet.domain.Vet;
import br.com.myvet.dto.attendance.AttendanceCreationRequestDto;
import br.com.myvet.dto.attendance.AttendanceSearchResponseDto;
import br.com.myvet.enumeration.TurnType;
import br.com.myvet.enumeration.UserType;
import br.com.myvet.mapper.AttendanceMapper;
import br.com.myvet.repository.AttendanceRepository;
import br.com.myvet.service.pet.PetService;
import br.com.myvet.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceMapper mapper;

    private final AttendanceRepository repository;

    private final UserService userService;

    private final PetService petService;

    @Override
    public void create(AttendanceCreationRequestDto requestDto) {
        final var vet = userService.findVetById(requestDto.getVetId());
        final var customer = userService.findCustomerById(requestDto.getCustomerId());
        final var pet = petService.findById(requestDto.getPetId());
        final var attendance = mapper.mapFromAttendanceRequest(vet, customer, pet, requestDto);
        repository.save(attendance);
    }

    @Override
    public List<AttendanceSearchResponseDto> search(Long userId) {
        final var user = userService.findByIdOrElseThrow(userId);
        return findByUser(user).stream()
                .map(mapper::mapToAttendanceSearchResponseDto)
                .collect(Collectors.toList());
    }
    @Override
    public void confirm(Long userId, Long attendanceId) {
        final var user = userService.findByIdOrElseThrow(userId);
        final var attendance = repository.findByIdAndVet(attendanceId, user)
                .orElseThrow(() -> new RuntimeException("Atendimento não encontrado"));
        mapper.mapToConfirm(attendance);
        repository.save(attendance);
    }

    @Override
    public void cancel(Long userId, Long attendanceId) {
        final var user = userService.findByIdOrElseThrow(userId);
        final var attendance = findByIdAndUser(attendanceId, user)
                .orElseThrow(() -> new RuntimeException("Atendimento não encontrado"));
        mapper.mapToCancel(attendance);
        repository.save(attendance);
    }

    @Override
    public boolean check(Vet vet, String fromTime, String toTime, TurnType turnType, LocalDate date) {
        return repository.existsByVetAndFromTimeAndToTimeAndTurnAndDate(vet, fromTime, toTime, turnType, date);
    }

    private List<Attendance> findByUser(User user) {
        if (UserType.CUSTOMER.equals(user.getType())) {
            return repository.findByCustomer(user);
        }
        return repository.findByVet(user);
    }

    private Optional<Attendance> findByIdAndUser(Long attendanceId, User user) {
        if (UserType.CUSTOMER.equals(user.getType())) {
            return repository.findByIdAndCustomer(attendanceId, user);
        }
        return repository.findByIdAndVet(attendanceId, user);
    }
}
