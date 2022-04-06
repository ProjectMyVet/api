package br.com.myvet.dto.attendance;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceFinishingRequestDto {

    @NotNull
    private Long userId;

    @NotNull
    private Long attendanceId;

    @NotBlank
    @Size(max = 255)
    private String period;

    @NotBlank
    @Size(max = 255)
    private String description;

}
