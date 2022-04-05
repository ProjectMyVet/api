package br.com.myvet.dto.vet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class VetSearchingScheduleResponseDto {

    private Long id;

    private String name;

    private String photoUrl;

    private String email;

    private String crmv;

    private String career;

}
