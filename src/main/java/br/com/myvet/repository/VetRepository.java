package br.com.myvet.repository;

import br.com.myvet.domain.Vet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VetRepository extends JpaRepository<Vet, Long> {
}
