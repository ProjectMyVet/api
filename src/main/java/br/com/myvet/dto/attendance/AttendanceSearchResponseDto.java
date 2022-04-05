package br.com.myvet.dto.attendance;

import br.com.myvet.domain.Pet;
import br.com.myvet.domain.User;
import br.com.myvet.enumeration.AttendanceStatus;
import br.com.myvet.enumeration.AttendanceType;
import br.com.myvet.enumeration.TurnType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceSearchResponseDto {

    private Long id;

    private String vetName;

    private String customerName;

    private AttendanceSearchPetResponseDto pet;

    private AttendanceStatus status;

    private AttendanceType type;

    private TurnType turn;

    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate date;

    private String fromTime;

    private String toTime;

}
