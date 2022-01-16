package pl.grzegorz.motorcycle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.grzegorz.motorcycle.model.BikerEntity;
import pl.grzegorz.motorcycle.model.CircuitEntity;
import pl.grzegorz.motorcycle.model.LapEntity;

import java.util.List;

@Repository
public interface LapRepository extends JpaRepository<LapEntity, Long> {

    List<LapEntity> findAllByBiker(BikerEntity bikerEntity);

    @Query(value = "SELECT l FROM LapEntity l WHERE l.circuit = ?1")
    List<LapEntity> findAllLapsByDateAndCircuit(CircuitEntity circuit);
}
