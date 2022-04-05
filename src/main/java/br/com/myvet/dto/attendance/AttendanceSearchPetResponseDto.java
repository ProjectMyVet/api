package br.com.myvet.dto.attendance;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceSearchPetResponseDto {

    private Long id;

    private String name;

    @JsonFormat(pattern="dd-MM-yyyy")
    private LocalDate birthDate;

}
