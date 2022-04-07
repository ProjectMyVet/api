package br.com.myvet.dto.evaluation;

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
public class EvaluationCreationRequestDto {

    @NotNull
    private Long customerId;

    @NotNull
    private Long attendanceId;

    @NotNull
    private Integer grade;

    @NotBlank
    @Size(max = 255)
    private String description;

}
