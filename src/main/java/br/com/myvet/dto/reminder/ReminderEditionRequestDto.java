package br.com.myvet.dto.reminder;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReminderEditionRequestDto {

    @NotNull //TODO alterar para date apenas
    private LocalDateTime date;

    @NotBlank
    @Size(max = 255)
    private String action;

}
