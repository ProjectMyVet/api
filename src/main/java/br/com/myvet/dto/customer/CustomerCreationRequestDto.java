package br.com.myvet.dto.customer;

import br.com.myvet.dto.user.UserCreationRequestDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerCreationRequestDto extends UserCreationRequestDto {


    @NotBlank
    @Size(max = 255)
    private String bio;

}
