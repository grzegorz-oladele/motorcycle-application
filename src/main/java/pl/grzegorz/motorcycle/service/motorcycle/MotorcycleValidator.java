package pl.grzegorz.motorcycle.service.motorcycle;

import org.springframework.stereotype.Component;
import pl.grzegorz.motorcycle.exception.motorcycle.MotorcycleError;
import pl.grzegorz.motorcycle.exception.motorcycle.MotorcycleException;
import pl.grzegorz.motorcycle.model.BikerEntity;
import pl.grzegorz.motorcycle.model.MotorcycleEntity;

import java.util.List;

@Component
public class MotorcycleValidator {
    protected void validationEmptyMotorcycleList(List<MotorcycleEntity> motorcycles) {
        if (motorcycles.isEmpty()) {
            throw new MotorcycleException(MotorcycleError.MOTORCYCLE_EMPTY_LIST);
        }
    }

    protected void validationSerialNumber(MotorcycleEntity bikeEntity, List<String> list) {
        for (String serialNumber : list) {
            if (bikeEntity.getSerialNumber().equals(serialNumber)) {
                throw new MotorcycleException(MotorcycleError.MOTORCYCLE_ALREADY_EXIST);
            }
        }
    }

    public void validationMotorcycleExist(MotorcycleEntity bikeEntity, List<BikerEntity> bikers) {
        for (BikerEntity biker : bikers) {
            for (MotorcycleEntity bike : biker.getBikes()) {
                if (bike.getSerialNumber().equals(bikeEntity.getSerialNumber())) {
                    throw new MotorcycleException(MotorcycleError.MOTORCYCLE_ALREADY_EXIST);
                }
            }
        }
    }
}
