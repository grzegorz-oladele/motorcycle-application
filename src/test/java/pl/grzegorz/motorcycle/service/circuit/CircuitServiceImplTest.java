package pl.grzegorz.motorcycle.service.circuit;

import org.junit.jupiter.api.Test;
import pl.grzegorz.motorcycle.PrepareTestData;
import pl.grzegorz.motorcycle.dto.circuit.CircuitDto;
import pl.grzegorz.motorcycle.mapper.CircuitMapper;
import pl.grzegorz.motorcycle.model.CircuitEntity;
import pl.grzegorz.motorcycle.repository.CircuitRepository;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class CircuitServiceImplTest {

    @Test
    void shouldSetLengthValue() {
//        given
        var circuitDto = new CircuitDto();
        circuitDto.setLength(3200);
        var circuitEntity = getCircuitEntity();
        var circuitRepository = mock(CircuitRepository.class);
        var circuitMapper = mock(CircuitMapper.class);
        var circuitValidator = mock(CircuitValidator.class);
        var circuitService = new CircuitServiceImpl(circuitRepository, circuitMapper, circuitValidator);
//        when
        given(circuitRepository.findById(1L)).willReturn(Optional.of(circuitEntity));
        circuitService.editLength(1, circuitDto);
//        then
        assertThat(circuitEntity.getLength(), is(3200));
        assertThat(circuitEntity.getLength(), is(not(5400)));
    }

    private CircuitEntity getCircuitEntity() {
        PrepareTestData prepareTestData = new PrepareTestData();
        return prepareTestData.circuits().get(0);
    }
}