package br.com.myvet.dto.pet;

import br.com.myvet.enumeration.PetType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PetCreationRequestDto {

    @NotNull
    private Long userId;

    @NotBlank
    @Size(max = 255)
    private String name;

    @NotBlank
    @Size(max = 255)
    private String breed;

    @NotNull
    private PetType type;

    @NotNull
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate birthDate;

}
