package pl.grzegorz.motorcycle.service.lap;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.grzegorz.motorcycle.dto.lap.LapDto;
import pl.grzegorz.motorcycle.dto.lap.LapDtoInfo;
import pl.grzegorz.motorcycle.mapper.LapMapper;
import pl.grzegorz.motorcycle.model.BikerEntity;
import pl.grzegorz.motorcycle.model.CircuitEntity;
import pl.grzegorz.motorcycle.model.LapEntity;
import pl.grzegorz.motorcycle.repository.LapRepository;
import pl.grzegorz.motorcycle.service.biker.BikerService;
import pl.grzegorz.motorcycle.service.circuit.CircuitService;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LapServiceImpl implements LapService {

    private final LapRepository lapRepository;
    private final LapMapper lapMapper;
    private final LapValidator lapValidator;
    private final BikerService bikerService;
    private final CircuitService circuitService;

    @Override
    public LapDtoInfo addLap(long bikerId, long circuitId, LapDto lapDto) {
        BikerEntity bikerEntity = bikerService.getBikerEntity(bikerId);
        CircuitEntity circuitEntity = circuitService.getCircuitEntity(circuitId);
        LapEntity lapEntity = lapMapper.fromDtoToEntity(lapDto);
        lapEntity.setBiker(bikerEntity);
        lapEntity.setCircuit(circuitEntity);
        lapRepository.save(lapEntity);
        return lapMapper.formEntityToDtoInfo(lapEntity);
    }

    @Override
    public List<LapDtoInfo> getAllLaps() {
        List<LapEntity> lists = lapRepository.findAll();
        lapValidator.validateEmptyList(lists);
        return toLapDtoList(lists);
    }

    @Override
    public List<LapDtoInfo> getAllLapsByBiker(long bikerId) {
        BikerEntity bikerEntity = bikerService.getBikerEntity(bikerId);
        List<LapEntity> list = lapRepository.findAllByBiker(bikerEntity);
        lapValidator.validateEmptyList(list);
        return toLapDtoList(list);
    }

    @Override
    public List<LapDtoInfo> getAllLapsByDateAndCircuit(long circuitId) {
        CircuitEntity circuitEntity = circuitService.getCircuitEntity(circuitId);
        List<LapEntity> list = lapRepository.findAllLapsByDateAndCircuit(circuitEntity);
        lapValidator.validateEmptyList(list);
        return toLapDtoList(list);    }

    private List<LapDtoInfo> toLapDtoList(List<LapEntity> laps) {
        return laps
                .stream()
                .map(lapMapper::formEntityToDtoInfo)
                .collect(Collectors.toList());
    }
}
