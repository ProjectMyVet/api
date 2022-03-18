package br.com.myvet.repository;

import br.com.myvet.domain.Pet;
import br.com.myvet.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PetRepository extends JpaRepository<Pet, Long> {

    List<Pet> findAllByUser(User user);

    Optional<Pet> findAllByIdAndUser(Long id, User user);

}
