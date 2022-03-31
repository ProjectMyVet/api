package br.com.myvet.repository;

import br.com.myvet.domain.Schedule;
import br.com.myvet.domain.User;
import br.com.myvet.enumeration.TurnType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SchedulerRepository extends JpaRepository<Schedule, Long> {

    void deleteByUserAndTurn(User user, TurnType turn);

    List<Schedule> findByUser(User user);

}
