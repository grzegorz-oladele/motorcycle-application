package pl.grzegorz.motorcycle.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.grzegorz.motorcycle.model.MotorcycleEntity;

import java.util.List;

@Repository
public interface MotorcycleRepository extends JpaRepository<MotorcycleEntity, Long> {

    @Query(value = "SELECT m FROM MotorcycleEntity m WHERE m.horsePower >= ?1 AND m.horsePower <= ?2")
    List<MotorcycleEntity> listOfBikesByHorsePower(int min, int max);

    @Query(value = "SELECT m FROM MotorcycleEntity m WHERE m.brand = ?1")
    List<MotorcycleEntity> listOfBikesByBrand(String brand);

    @Query(value = "SELECT m FROM MotorcycleEntity m WHERE m.model = ?1")
    List<MotorcycleEntity> listOfBikesByModel(String model);

    @Query(value = "SELECT m FROM MotorcycleEntity m WHERE m.capacity >= ?1 AND m.capacity <= ?2")
    List<MotorcycleEntity> listOfBikesByCapacity(int min, int max);

    @Query("SELECT m.serialNumber FROM MotorcycleEntity m")
    List<String> findAllSerialNumbers();
}
