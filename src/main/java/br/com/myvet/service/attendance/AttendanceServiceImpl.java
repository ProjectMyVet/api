package br.com.myvet.service.attendance;

import br.com.myvet.domain.Attendance;
import br.com.myvet.domain.User;
import br.com.myvet.domain.Vet;
import br.com.myvet.dto.attendance.AttendanceCreationRequestDto;
import br.com.myvet.dto.attendance.AttendanceFinishingRequestDto;
import br.com.myvet.dto.attendance.AttendanceSearchResponseDto;
import br.com.myvet.dto.customer.CustomerSearchingResponseDto;
import br.com.myvet.dto.evaluation.EvaluationCreationRequestDto;
import br.com.myvet.dto.treatment.TreatmentSearchingResponseDto;
import br.com.myvet.dto.vet.VetSearchingResponseDto;
import br.com.myvet.enumeration.AttendanceStatus;
import br.com.myvet.enumeration.TurnType;
import br.com.myvet.enumeration.UserType;
import br.com.myvet.mapper.AttendanceMapper;
import br.com.myvet.mapper.CustomerMapper;
import br.com.myvet.mapper.VetMapper;
import br.com.myvet.repository.AttendanceRepository;
import br.com.myvet.service.evaluation.EvaluationService;
import br.com.myvet.service.pet.PetService;
import br.com.myvet.service.treatment.TreatmentService;
import br.com.myvet.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static br.com.myvet.enumeration.AttendanceStatus.*;

@Service
@RequiredArgsConstructor
public class AttendanceServiceImpl implements AttendanceService {

    private final EvaluationService evaluationService;

    private final TreatmentService treatmentService;

    private final AttendanceRepository repository;

    private final CustomerMapper customerMapper;

    private final AttendanceMapper mapper;

    private final UserService userService;

    private final PetService petService;

    private final VetMapper vetMapper;

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

    @Override
    public void finish(AttendanceFinishingRequestDto requestDto) {
        final var user = userService.findByIdOrElseThrow(requestDto.getUserId());
        final var attendance = findByIdAndUser(requestDto.getAttendanceId(), user)
                .orElseThrow(() -> new RuntimeException("Atendimento não encontrado"));
        mapper.mapToFinish(attendance);
        final var attendanceUpdated = repository.save(attendance);
        treatmentService.create(attendanceUpdated, requestDto.getPeriod(), requestDto.getDescription());
    }

    @Override
    public List<TreatmentSearchingResponseDto> searchTreatments(Long userId, Long petId) {
        final var customer = userService.findByIdOrElseThrow(userId);
        final var pet = petService.findByUserAndId(customer, petId);
        final List<Attendance> attendances = repository.findByCustomerAndPet(customer, pet);
        return treatmentService.search(attendances);
    }

    @Override
    public CustomerSearchingResponseDto searchCustomerProfile(Long customerId) {
        final var customer = userService.findCustomerById(customerId);
        final var attendances = repository.countByCustomer(customer);
        final var pets = petService.countByUser(customer);
        return customerMapper.mapToCustomerSearchResponseDto(customer, attendances, pets);
    }

    @Override
    public VetSearchingResponseDto searchVetProfile(Long vetId) {
        final var vet = userService.findVetById(vetId);
        final var confirmedAttendances = repository.countByVetAndStatus(vet, CONFIRMED);
        final var requestedAttendances = repository.countByVetAndStatus(vet, REQUESTED);
        final var finishedAttendances = repository.countByVetAndStatusIn(vet, Arrays.asList(FINISHED, EVALUATED));
        final List<Attendance> attendances = repository.findByVetAndStatus(vet, EVALUATED);
        final Double grade = evaluationService.searchGradeAverageByAttendances(attendances);
        return vetMapper.mapToVetSearchingResponseDto(vet, confirmedAttendances, requestedAttendances, finishedAttendances, grade);
    }

    @Override
    public void createEvaluation(EvaluationCreationRequestDto requestDto) {
        final var customer = userService.findCustomerById(requestDto.getCustomerId());
        final var attendance = repository.findByIdAndCustomer(requestDto.getAttendanceId(), customer)
                .orElseThrow(() -> new RuntimeException("Atendimento não encontrado"));
        evaluationService.create(attendance, requestDto);
        mapper.mapToEvaluated(attendance);
        repository.save(attendance);
    }

    @Override
    public List<Attendance> findByVetAndStatus(User vet, AttendanceStatus status) {
        return repository.findByVetAndStatus(vet, status);
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
