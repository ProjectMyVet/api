package br.com.myvet.dto.pet;

import br.com.myvet.enumeration.PetType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class PetEditionRequestDto {

    @NotNull
    private Long id;

    @NotBlank
    @Size(max = 255)
    private String name;

    @NotNull
    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate birthDate;

    @NotBlank
    @Size(max = 255)
    private String breed;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private PetType type;

}
