package br.com.myvet.dto.medication;

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
public class MedicationCreationResponseDto {

    @NotNull
    private Long petId;

    @NotNull
    private Long customerId;

    @NotBlank
    @Size(max = 255)
    private String type;

    @NotBlank
    @Size(max = 255)
    private String description;

}
