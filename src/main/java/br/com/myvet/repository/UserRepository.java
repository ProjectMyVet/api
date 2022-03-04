package br.com.myvet.repository;

import br.com.myvet.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    boolean existsByIdToken(String idToken);

    Optional<User> findByIdToken(String idToken);

}
