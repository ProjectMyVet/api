package br.com.myvet.repository;

import br.com.myvet.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByIdToken(String idToken);

}
