package pl.grzegorz.motorcycle.service.lap;

import org.junit.jupiter.api.Test;
import pl.grzegorz.motorcycle.PrepareTestData;
import pl.grzegorz.motorcycle.dto.lap.LapDto;
import pl.grzegorz.motorcycle.dto.lap.LapDtoInfo;
import pl.grzegorz.motorcycle.mapper.BikerMapper;
import pl.grzegorz.motorcycle.mapper.CircuitMapper;
import pl.grzegorz.motorcycle.mapper.LapMapper;
import pl.grzegorz.motorcycle.mapper.MotorcycleMapper;
import pl.grzegorz.motorcycle.model.BikerEntity;
import pl.grzegorz.motorcycle.model.CircuitEntity;
import pl.grzegorz.motorcycle.repository.BikerRepository;
import pl.grzegorz.motorcycle.repository.CircuitRepository;
import pl.grzegorz.motorcycle.repository.LapRepository;
import pl.grzegorz.motorcycle.repository.MotorcycleRepository;
import pl.grzegorz.motorcycle.service.biker.BikerServiceImpl;
import pl.grzegorz.motorcycle.service.biker.BikerValidator;
import pl.grzegorz.motorcycle.service.circuit.CircuitServiceImpl;
import pl.grzegorz.motorcycle.service.circuit.CircuitValidator;
import pl.grzegorz.motorcycle.service.motorcycle.MotorcycleValidator;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class LapServiceImplTest {

    @Test
    void shouldSetBikerValueAndShouldSetCircuitValue() {
//        given
        var circuit = getCircuits().get(0);
        var biker = getBikers().get(0);
        LapDto lapDto = new LapDto();
        var lapRepository = mock(LapRepository.class);
        var motorcycleMapper = mock(MotorcycleMapper.class);
        var bikerMapper = new BikerMapper(motorcycleMapper);
        var circuitMapper = new CircuitMapper();
        var lapMapper = new LapMapper(bikerMapper, circuitMapper);
        var lapValidator = mock(LapValidator.class);
        var motorcycleRepository = mock(MotorcycleRepository.class);
        var circuitRepository = mock(CircuitRepository.class);
        var circuitValidator = new CircuitValidator();
        var circuitService = new CircuitServiceImpl(circuitRepository, circuitMapper, circuitValidator);
        var bikerRepository = mock(BikerRepository.class);
        var bikerValidator = new BikerValidator();
        var motorcycleValidator = new MotorcycleValidator();
        var bikerService = new BikerServiceImpl(bikerRepository, motorcycleRepository, bikerMapper, bikerValidator,
                motorcycleValidator);
        var lapService = new LapServiceImpl(lapRepository, lapMapper, lapValidator, bikerService, circuitService);
//        when
        given(circuitRepository.findById(4L)).willReturn(Optional.of(circuit));
        given(bikerRepository.findById(8L)).willReturn(Optional.of(biker));
        LapDtoInfo lap = lapService.addLap(8, 4, lapDto);
//        then
        assertThat(lap, is(instanceOf(LapDtoInfo.class)));
        assertThat(lap.getBiker().getUsername(), is(bikerMapper.fromEntityToDtoInfo(biker).getUsername()));
        assertThat(lap.getCircuit().getName(), is(circuitMapper.fromEntityToDtoInfo(circuit).getName()));
        assertThat(lap.getCircuit().getLength(), is(circuitMapper.fromEntityToDtoInfo(circuit).getLength()));
    }

    private List<CircuitEntity> getCircuits() {
        PrepareTestData prepareTestData = new PrepareTestData();
        return prepareTestData.circuits();
    }

    private List<BikerEntity> getBikers() {
        PrepareTestData prepareTestData = new PrepareTestData();
        return prepareTestData.bikers();
    }

}