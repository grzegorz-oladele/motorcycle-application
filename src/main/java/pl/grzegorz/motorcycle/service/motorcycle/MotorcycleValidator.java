package pl.grzegorz.motorcycle.service.motorcycle;

import org.springframework.stereotype.Component;
import pl.grzegorz.motorcycle.exception.motorcycle.MotorcycleError;
import pl.grzegorz.motorcycle.exception.motorcycle.MotorcycleException;
import pl.grzegorz.motorcycle.model.MotorcycleEntity;

import java.util.List;

@Component
public class MotorcycleValidator {
    protected void validationEmptyMotorcycleList(List<MotorcycleEntity> motorcycles) {
        if (motorcycles.isEmpty()) {
            throw new MotorcycleException(MotorcycleError.MOTORCYCLE_EMPTY_LIST);
        }
    }

    protected void validationSerialNumber(MotorcycleEntity motorcycleEntity, List<String> list) {
        for (String serialNumber : list) {
            if (motorcycleEntity.getSerialNumber().equals(serialNumber)) {
                throw new MotorcycleException(MotorcycleError.MOTORCYCLE_ALREADY_EXIST);
            }
        }
    }

    public void validationMotorcycleExist(MotorcycleEntity motorcycleEntity, List<MotorcycleEntity> motorcycleEntityList) {
        for (MotorcycleEntity entity : motorcycleEntityList) {
            if (entity.getSerialNumber().equals(motorcycleEntity.getSerialNumber())) {
                throw new MotorcycleException(MotorcycleError.MOTORCYCLE_ALREADY_EXIST);
            }
        }
    }
}
