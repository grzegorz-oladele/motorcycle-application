package pl.grzegorz.motorcycle.service.circuit;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.grzegorz.motorcycle.dto.circuit.CircuitDto;
import pl.grzegorz.motorcycle.dto.circuit.CircuitDtoInfo;
import pl.grzegorz.motorcycle.exception.circuit.CircuitError;
import pl.grzegorz.motorcycle.exception.circuit.CircuitException;
import pl.grzegorz.motorcycle.mapper.CircuitMapper;
import pl.grzegorz.motorcycle.model.CircuitEntity;
import pl.grzegorz.motorcycle.repository.CircuitRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CircuitServiceImpl implements CircuitService {

    private final CircuitRepository circuitRepository;
    private final CircuitMapper circuitMapper;
    private final CircuitValidator circuitValidator;

    @Override
    public List<CircuitDtoInfo> getAllCircuits() {
        List<CircuitEntity> list = circuitRepository.findAll();
        circuitValidator.validateCircuitsEmptyList(list);
        return toCircuitsDtoList(list);
    }

    @Override
    public CircuitDtoInfo getCircuitById(long id) {
        CircuitEntity circuitEntity = getCircuitEntity(id);
        return circuitMapper.fromEntityToDtoInfo(circuitEntity);
    }

    @Override
    public CircuitEntity getCircuitEntity(long id) {
        return circuitRepository.findById(id)
                .orElseThrow(() -> new CircuitException(CircuitError.CIRCUIT_NOT_FOUND));
    }

    @Override
    public CircuitDtoInfo addCircuit(CircuitDto circuitDto) {
        CircuitEntity circuitEntity = circuitMapper.fromDtoToEntity(circuitDto);
        circuitRepository.save(circuitEntity);
        return circuitMapper.fromEntityToDtoInfo(circuitEntity);
    }

    @Override
    public void removeCircuit(long id) {
        CircuitEntity circuitEntity = getCircuitEntity(id);
        circuitRepository.delete(circuitEntity);
    }

    @Override
    public void editLength(long id, CircuitDto circuitDto) {
        CircuitEntity circuitEntity = getCircuitEntity(id);
        circuitEntity.setLength(circuitDto.getLength());
        circuitRepository.save(circuitEntity);
    }

    private List<CircuitDtoInfo> toCircuitsDtoList(List<CircuitEntity> list) {
        return list
                .stream()
                .map(circuitMapper::fromEntityToDtoInfo)
                .collect(Collectors.toList());
    }
}
