package br.com.myvet.repository;

import br.com.myvet.domain.*;
import br.com.myvet.enumeration.AttendanceStatus;
import br.com.myvet.enumeration.TurnType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {

    List<Evaluation> findByAttendanceIn(List<Attendance> attendances);

}
