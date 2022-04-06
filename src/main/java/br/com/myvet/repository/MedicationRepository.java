package br.com.myvet.repository;

import br.com.myvet.domain.Medication;
import br.com.myvet.domain.Pet;
import br.com.myvet.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedicationRepository extends JpaRepository<Medication, Long> {

    List<Medication> findByCustomerAndPet(User user, Pet pet);

}
