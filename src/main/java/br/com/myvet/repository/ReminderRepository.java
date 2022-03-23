package br.com.myvet.repository;

import br.com.myvet.domain.Reminder;
import br.com.myvet.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReminderRepository extends JpaRepository<Reminder, Long> {

    List<Reminder> findByUser(User user);

}
