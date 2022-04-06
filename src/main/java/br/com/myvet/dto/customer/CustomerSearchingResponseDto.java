package br.com.myvet.dto.customer;

import br.com.myvet.enumeration.UserType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerSearchingResponseDto {

    private String name;

    private String email;

    private UserType type;

    private String photoUrl;

    private String bio;

    private Long quantityAttendance;

    private Long quantityPet;

}
