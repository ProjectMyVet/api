package br.com.myvet.dto.attendance;

import br.com.myvet.enumeration.AttendanceType;
import br.com.myvet.enumeration.TurnType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceCreationRequestDto {

    @NotNull
    private Long customerId;

    @NotNull
    private Long vetId;

    @NotNull
    private Long petId;

    @NotNull
    private AttendanceType type;

    @NotNull
    private TurnType turn;

    @NotNull
    @JsonFormat(pattern="dd-MM-yyyy")
    @Column(name = "attendance_date")
    private LocalDate date;

    @NotBlank
    @Size(max = 30)
    private String fromTime;

    @NotBlank
    @Size(max = 30)
    private String toTime;

}
