package br.com.myvet.domain;

import br.com.myvet.enumeration.AttendanceStatus;
import br.com.myvet.enumeration.AttendanceType;
import br.com.myvet.enumeration.TurnType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private User customer;

    @ManyToOne
    @JoinColumn(name = "vet_id")
    private User vet;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private AttendanceStatus status;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private AttendanceType type;

    @NotNull
    @Enumerated(value = EnumType.STRING)
    private TurnType turn;

    @NotNull
    @Column(name = "attendance_date")
    private LocalDate date;

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
