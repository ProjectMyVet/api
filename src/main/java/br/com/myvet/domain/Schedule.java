package br.com.myvet.domain;

import br.com.myvet.enumeration.TurnType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Vet vet;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private TurnType turn;

    @NotNull
    private Integer dayOfWeek;

    @NotBlank
    @Size(max = 30)
    private String fromTime;

    @NotBlank
    @Size(max = 30)
    private String toTime;

    @NotNull
    private LocalDateTime createdAt;

    @NotNull
    private LocalDateTime updatedAt;

}
