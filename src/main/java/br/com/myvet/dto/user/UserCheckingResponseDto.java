package br.com.myvet.dto.user;

import br.com.myvet.enumeration.UserType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCheckingResponseDto {

    private Long id;

    private Boolean exists;

    private UserType userType;

}
