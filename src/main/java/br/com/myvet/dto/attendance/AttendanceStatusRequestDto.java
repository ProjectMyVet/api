package br.com.myvet.dto.attendance;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceStatusRequestDto {

    @NotNull
    private Long userId;

    @NotNull
    private Long attendanceId;

}
