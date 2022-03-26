package br.com.myvet.dto.reminder;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReminderSearchingResponseDto {

    private Long id;

    @JsonFormat(pattern="dd-MM-yyyy HH:mm")
    private LocalDateTime date;

    private String action;

}
