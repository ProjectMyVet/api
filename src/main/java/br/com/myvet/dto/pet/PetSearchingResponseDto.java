package br.com.myvet.dto.pet;

import br.com.myvet.enumeration.PetType;
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
public class PetSearchingResponseDto {

    private Long id;

    private String name;

    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate birthDate;

    private String breed;

    private PetType type;

}
