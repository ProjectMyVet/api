package br.com.myvet.dto.vet;

import br.com.myvet.enumeration.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class VetSearchResponseDto {

    private String name;

    private String email;

    private UserType type;

    private String photoUrl;

    private String crmv;

    private String career;

}
