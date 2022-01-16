package pl.grzegorz.motorcycle.service.circuit;

import pl.grzegorz.motorcycle.dto.circuit.CircuitDto;
import pl.grzegorz.motorcycle.dto.circuit.CircuitDtoInfo;
import pl.grzegorz.motorcycle.model.CircuitEntity;

import java.util.List;

public interface CircuitService {

    List<CircuitDtoInfo> getAllCircuits();

    CircuitDtoInfo getCircuitById(long id);

    CircuitEntity getCircuitEntity(long id);

    CircuitDtoInfo addCircuit(CircuitDto circuitDto);

    void removeCircuit(long id);

    void editLength(long id, CircuitDto circuitDto);
}
