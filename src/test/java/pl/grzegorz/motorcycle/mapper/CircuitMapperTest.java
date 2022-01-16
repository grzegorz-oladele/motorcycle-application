package pl.grzegorz.motorcycle.mapper;

import org.junit.jupiter.api.Test;
import pl.grzegorz.motorcycle.dto.circuit.CircuitDto;
import pl.grzegorz.motorcycle.dto.circuit.CircuitDtoInfo;
import pl.grzegorz.motorcycle.model.CircuitEntity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class CircuitMapperTest {

    @Test
    void shouldReturnNullWhenCircuitDtoWillBeNull() {
//        given
        CircuitDto circuitDto = null;
        var circuitMapper = new CircuitMapper();
//        when
        var circuitEntity = circuitMapper.fromDtoToEntity(circuitDto);
//        then
        assertNull(circuitEntity);
    }

    @Test
    void shouldReturnCircuitEntityWhenCircuitDtoWillBeNotNull() {
//        given
        var circuitDto = new CircuitDto();
        circuitDto.setName("Tor Modlin");
        circuitDto.setCity("Modlin");
        circuitDto.setLength(1200);
        var circuitMapper = new CircuitMapper();
//        when
        var circuitEntity = circuitMapper.fromDtoToEntity(circuitDto);
//        then
        assertThat(circuitEntity, is(instanceOf(CircuitEntity.class)));
        assertThat(circuitEntity.getName(), is(circuitDto.getName()));
        assertThat(circuitEntity.getCity(), is(circuitDto.getCity()));
        assertThat(circuitEntity.getLength(), is(circuitDto.getLength()));
    }

    @Test
    void shouldReturnNullWhenCircuitEntityWillBeNull() {
//        given
        CircuitEntity circuitEntity = null;
        var circuitMapper = new CircuitMapper();
//        when
        var circuitDtoInfo = circuitMapper.fromEntityToDtoInfo(circuitEntity);
//        then
        assertNull(circuitDtoInfo);
    }

    @Test
    void shouldReturnCircuitDtoInfoWhenCircuitEntityWillBeNotNull() {
//        given
        var circuitEntity = new CircuitEntity();
        circuitEntity.setId(9);
        circuitEntity.setName("Tor Modlin");
        circuitEntity.setCity("Modlin");
        circuitEntity.setLength(1200);
        var circuitMapper = new CircuitMapper();
//        when
        var circuitDtoInfo = circuitMapper.fromEntityToDtoInfo(circuitEntity);
//        then
        assertThat(circuitDtoInfo, is(instanceOf(CircuitDtoInfo.class)));
        assertThat(circuitDtoInfo.getId(), is(circuitEntity.getId()));
        assertThat(circuitDtoInfo.getName(), is(circuitEntity.getName()));
        assertThat(circuitDtoInfo.getCity(), is(circuitEntity.getCity()));
        assertThat(circuitDtoInfo.getLength(), is(circuitEntity.getLength()));
    }

}