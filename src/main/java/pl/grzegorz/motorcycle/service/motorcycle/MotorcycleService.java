package pl.grzegorz.motorcycle.service.motorcycle;

import pl.grzegorz.motorcycle.dto.motorcycle.MotorcycleDto;
import pl.grzegorz.motorcycle.dto.motorcycle.MotorcycleDtoInfo;

import java.util.List;

public interface MotorcycleService {

    MotorcycleDtoInfo getMotorcycleById(long id);

    List<MotorcycleDtoInfo> getAllMotorcycles();

    MotorcycleDtoInfo addMotorcycle(MotorcycleDto motorcycleDto);

    void removeMotorcycle(long id);

    MotorcycleDtoInfo editCapacity(long id, int capacity);

    MotorcycleDtoInfo editHorsePower(long id, int horsePower);

    List<MotorcycleDtoInfo> getAllByHorsePower(int min, int max);

    List<MotorcycleDtoInfo> getAllByBrand(String brand);

    List<MotorcycleDtoInfo> getAllByModel(String model);

    List<MotorcycleDtoInfo> getAllByCapacity(int min, int max);
}
