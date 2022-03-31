package br.com.myvet.dto.scheduler;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SchedulerCreationDateRequestDto {

    private Integer dayOfWeek;

    @NotBlank
    @Size(max = 30)
    private String fromTime;

    @NotBlank
    @Size(max = 30)
    private String toTime;

    private boolean checked;

}
