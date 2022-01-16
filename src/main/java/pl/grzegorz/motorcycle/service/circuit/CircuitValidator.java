package pl.grzegorz.motorcycle.service.circuit;

import org.springframework.stereotype.Component;
import pl.grzegorz.motorcycle.exception.circuit.CircuitError;
import pl.grzegorz.motorcycle.exception.circuit.CircuitException;
import pl.grzegorz.motorcycle.model.CircuitEntity;

import java.util.List;

@Component
public class CircuitValidator {

    protected void validateCircuitsEmptyList(List<CircuitEntity> list) {
        if (list.isEmpty()) {
            throw new CircuitException(CircuitError.CIRCUITS_EMPTY_LIST);
        }
    }
}
