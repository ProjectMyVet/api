package br.com.myvet.dto.scheduler;

import br.com.myvet.enumeration.TurnType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SchedulerCreationRequestDto {

    private Long userId;

    private TurnType turn;

    private List<SchedulerCreationDateRequestDto> dates;

}
