package pl.grzegorz.motorcycle.mapper;

import org.junit.jupiter.api.Test;
import pl.grzegorz.motorcycle.PrepareTestData;
import pl.grzegorz.motorcycle.dto.lap.LapDto;
import pl.grzegorz.motorcycle.dto.lap.LapDtoInfo;
import pl.grzegorz.motorcycle.model.BikerEntity;
import pl.grzegorz.motorcycle.model.CircuitEntity;
import pl.grzegorz.motorcycle.model.LapEntity;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class LapMapperTest {
    @Test
    void shouldReturnNullWhenLapDtoWillBeNull() {
//        given
        LapDto lapDto = null;
        var bikerMapper = mock(BikerMapper.class);
        var circuitMapper = mock(CircuitMapper.class);
        var lapMapper = new LapMapper(bikerMapper, circuitMapper);
//        when
        var lapEntity = lapMapper.fromDtoToEntity(lapDto);
//        then
        assertNull(lapEntity);
    }

    @Test
    void shouldReturnLapEntityWhenLapDtoWillBeNotNull() {
//        given
        var lapDto = new LapDto();
        lapDto.setTime("1:33:444");
        var bikerMapper = mock(BikerMapper.class);
        var circuitMapper = mock(CircuitMapper.class);
        var lapMapper = new LapMapper(bikerMapper, circuitMapper);
//        when
        var lapEntity = lapMapper.fromDtoToEntity(lapDto);
        assertThat(lapEntity, is(instanceOf(LapEntity.class)));
        assertThat(lapEntity.getTime(), is(lapDto.getTime()));
    }

    @Test
    void shouldReturnNullWhenLapEntityWillBeNull() {
//        given
        var motorcycleMapper = mock(MotorcycleMapper.class);
        var lapEntity = new LapEntity();
        lapEntity.setId(1);
        lapEntity.setTime("1:22:333");
        lapEntity.setBiker(getBikers().get(0));
        lapEntity.setCircuit(getCircuits().get(0));
        lapEntity.setDate(LocalDate.parse("2022-01-04"));
        var bikerMapper = new BikerMapper(motorcycleMapper);
        var circuitMapper = new CircuitMapper();
        var lapMapper = new LapMapper(bikerMapper, circuitMapper);
//        when
        var lapDtoInfo = lapMapper.formEntityToDtoInfo(lapEntity);
//        then
//        System.out.println(lapDtoInfo.get);
        assertThat(lapDtoInfo, is(instanceOf(LapDtoInfo.class)));
        assertThat(lapDtoInfo.getId(), is(lapEntity.getId()));
        assertThat(lapDtoInfo.getBiker().getId(), is(lapEntity.getBiker().getId()));
        assertThat(lapDtoInfo.getBiker().getUsername(), is(lapEntity.getBiker().getName()));
        assertThat(lapDtoInfo.getCircuit().getId(), is(lapEntity.getCircuit().getId()));
        assertThat(lapDtoInfo.getCircuit().getName(), is(lapEntity.getCircuit().getName()));
        assertThat(lapDtoInfo.getCircuit().getCity(), is(lapEntity.getCircuit().getCity()));
        assertThat(lapDtoInfo.getCircuit().getLength(), is(lapEntity.getCircuit().getLength()));
        assertThat(lapDtoInfo.getTime(), is(lapEntity.getTime()));
        assertThat(lapDtoInfo.getDate(), is(lapEntity.getDate()));
    }

    private List<BikerEntity> getBikers() {
        PrepareTestData prepareTestData = new PrepareTestData();
        return prepareTestData.bikers();
    }

    private List<CircuitEntity> getCircuits() {
        PrepareTestData prepareTestData = new PrepareTestData();
        return prepareTestData.circuits();
    }
}