package br.com.myvet.dto.scheduler;

import br.com.myvet.enumeration.TurnType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SchedulerSearchingResponseDto {

    private Long id;

    private TurnType turn;

    private Integer dayOfWeek;

    private String fromTime;

    private String toTime;

}
