package br.com.myvet.mapper;

import br.com.myvet.domain.Attendance;
import br.com.myvet.domain.Customer;
import br.com.myvet.domain.Pet;
import br.com.myvet.domain.Vet;
import br.com.myvet.dto.attendance.AttendanceCreationRequestDto;
import br.com.myvet.dto.attendance.AttendanceSearchPetResponseDto;
import br.com.myvet.dto.attendance.AttendanceSearchResponseDto;
import br.com.myvet.enumeration.AttendanceStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class AttendanceMapper {

    public Attendance mapFromAttendanceRequest(Vet vet, Customer customer, Pet pet, AttendanceCreationRequestDto requestDto) {
        return Attendance.builder()
                .vet(vet)
                .pet(pet)
                .customer(customer)
                .type(requestDto.getType())
                .turn(requestDto.getTurn())
                .date(requestDto.getDate())
                .status(AttendanceStatus.REQUESTED)
                .fromTime(requestDto.getFromTime())
                .toTime(requestDto.getToTime())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    public AttendanceSearchResponseDto mapToAttendanceSearchResponseDto(Attendance attendance) {
        return AttendanceSearchResponseDto.builder()
                .id(attendance.getId())
                .customerName(attendance.getCustomer().getName())
                .date(attendance.getDate())
                .fromTime(attendance.getFromTime())
                .pet(AttendanceSearchPetResponseDto.builder()
                        .id(attendance.getPet().getId())
                        .name(attendance.getPet().getName())
                        .birthDate(attendance.getPet().getBirthDate())
                        .build())
                .status(attendance.getStatus())
                .toTime(attendance.getToTime())
                .turn(attendance.getTurn())
                .type(attendance.getType())
                .vetName(attendance.getVet().getName())
                .build();
    }

    public void mapToConfirm(Attendance attendance) {
        attendance.setStatus(AttendanceStatus.CONFIRMED);
        attendance.setUpdatedAt(LocalDateTime.now());
    }

    public void mapToCancel(Attendance attendance) {
        attendance.setStatus(AttendanceStatus.CANCELLED);
        attendance.setUpdatedAt(LocalDateTime.now());
    }
}
