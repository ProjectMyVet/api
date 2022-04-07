package br.com.myvet.repository;

import br.com.myvet.domain.Attendance;
import br.com.myvet.domain.Pet;
import br.com.myvet.domain.User;
import br.com.myvet.domain.Vet;
import br.com.myvet.enumeration.AttendanceStatus;
import br.com.myvet.enumeration.TurnType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    List<Attendance> findByVet(User user);

    List<Attendance> findByVetAndStatus(User user, AttendanceStatus status);

    List<Attendance> findByCustomer(User user);

    Optional<Attendance> findByIdAndVet(Long attendanceId, User user);

    Optional<Attendance> findByIdAndCustomer(Long attendanceId, User user);

    boolean existsByVetAndFromTimeAndToTimeAndTurnAndDate(Vet vet, String fromTime, String toTime, TurnType turnType, LocalDate date);

    List<Attendance> findByCustomerAndPet(User user, Pet pet);

    Long countByVetAndStatus(User vet, AttendanceStatus status);

    Long countByVetAndStatusIn(User vet, List<AttendanceStatus> status);

    Long countByCustomer(User customer);

}
