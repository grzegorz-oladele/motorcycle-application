package pl.grzegorz.motorcycle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.grzegorz.motorcycle.model.BikerEntity;

import java.util.List;

@Repository
public interface BikerRepository extends JpaRepository<BikerEntity, Long> {

    @Query(value = "SELECT b FROM BikerEntity b WHERE b.isActive = true")
    List<BikerEntity> findAll();

    @Query(value = "SELECT b.email FROM BikerEntity b")
    List<String> getBikersEmails();
}
