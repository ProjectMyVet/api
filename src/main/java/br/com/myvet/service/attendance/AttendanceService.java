package br.com.myvet.service.attendance;

import br.com.myvet.domain.Vet;
import br.com.myvet.dto.attendance.AttendanceCreationRequestDto;
import br.com.myvet.dto.attendance.AttendanceSearchResponseDto;
import br.com.myvet.enumeration.TurnType;

import java.time.LocalDate;
import java.util.List;

public interface AttendanceService {

    void create(AttendanceCreationRequestDto requestDto);

    List<AttendanceSearchResponseDto> search(Long userId);

    void confirm(Long userId, Long attendanceId);

    void cancel(Long userId, Long attendanceId);

    boolean check(Vet vet, String fromTime, String toTime, TurnType turnType, LocalDate date);

}
