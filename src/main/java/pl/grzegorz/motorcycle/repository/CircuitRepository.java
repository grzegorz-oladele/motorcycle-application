package pl.grzegorz.motorcycle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.grzegorz.motorcycle.model.CircuitEntity;

@Repository
public interface CircuitRepository extends JpaRepository<CircuitEntity, Long> {
}
