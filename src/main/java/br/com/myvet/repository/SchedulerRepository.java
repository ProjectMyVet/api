package br.com.myvet.repository;

import br.com.myvet.domain.Schedule;
import br.com.myvet.domain.Vet;
import br.com.myvet.enumeration.TurnType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SchedulerRepository extends JpaRepository<Schedule, Long> {

    void deleteByVetAndTurn(Vet vet, TurnType turn);

    List<Schedule> findByVet(Vet vet);

    List<Schedule> findByFromTimeAndToTimeAndTurnAndDayOfWeek(String fromTime, String toTime, TurnType turn, Integer dayOfWeek);

}
