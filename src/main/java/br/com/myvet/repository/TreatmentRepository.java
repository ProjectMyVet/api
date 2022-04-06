package br.com.myvet.repository;

import br.com.myvet.domain.Attendance;
import br.com.myvet.domain.Treatment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TreatmentRepository extends JpaRepository<Treatment, Long> {

    List<Treatment> findByAttendanceIn(List<Attendance> attendance);

}
