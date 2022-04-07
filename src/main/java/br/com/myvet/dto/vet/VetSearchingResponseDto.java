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
public class VetSearchingResponseDto {

    private String name;

    private String email;

    private UserType type;

    private String photoUrl;

    private String crmv;

    private String career;

    private Long quantityFinishedAttendance;

    private Long quantityRequestedAttendance;

    private Long quantityConfirmedAttendance;

    private Double grade;

}
