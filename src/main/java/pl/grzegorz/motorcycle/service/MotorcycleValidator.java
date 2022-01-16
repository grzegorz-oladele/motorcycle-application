package pl.grzegorz.motorcycle.service;

import org.springframework.stereotype.Component;
import pl.grzegorz.motorcycle.exception.MotorcycleError;
import pl.grzegorz.motorcycle.exception.MotorcycleException;
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

    public void validationMotorcycleExist(MotorcycleEntity bikeEntity, List<MotorcycleEntity> bikers) {
        for (MotorcycleEntity biker : bikers) {
            for (MotorcycleEntity bike : biker.getBikes()) {
                if (bike.getSerialNumber().equals(bikeEntity.getSerialNumber())) {
                    throw new MotorcycleException(MotorcycleError.MOTORCYCLE_ALREADY_EXIST);
                }
            }
        }
    }
}
