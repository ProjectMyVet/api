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

import java.time.LocalDate;
import java.util.List;

public interface AttendanceService {

    void create(AttendanceCreationRequestDto requestDto);

    List<AttendanceSearchResponseDto> search(Long userId);

    void confirm(Long userId, Long attendanceId);

    void cancel(Long userId, Long attendanceId);

    boolean check(Vet vet, String fromTime, String toTime, TurnType turnType, LocalDate date);

    void finish(AttendanceFinishingRequestDto requestDto);

    List<TreatmentSearchingResponseDto> searchTreatments(Long userId, Long petId);

    CustomerSearchingResponseDto searchCustomerProfile(Long customerId);

    VetSearchingResponseDto searchVetProfile(Long vetId);

    void createEvaluation(EvaluationCreationRequestDto requestDto);

    List<Attendance> findByVetAndStatus(User vet, AttendanceStatus status);

}
