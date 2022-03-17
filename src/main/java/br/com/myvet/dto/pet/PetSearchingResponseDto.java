package br.com.myvet.dto.pet;

import br.com.myvet.enumeration.PetType;
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

    private LocalDate birthDate;

    private String breed;

    private PetType type;

}
