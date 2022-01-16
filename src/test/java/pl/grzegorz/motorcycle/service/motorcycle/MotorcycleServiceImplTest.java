package pl.grzegorz.motorcycle.service.motorcycle;

import org.junit.jupiter.api.Test;
import pl.grzegorz.motorcycle.PrepareTestData;
import pl.grzegorz.motorcycle.mapper.MotorcycleMapper;
import pl.grzegorz.motorcycle.model.MotorcycleEntity;
import pl.grzegorz.motorcycle.repository.MotorcycleRepository;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class MotorcycleServiceImplTest {

    @Test
    void shouldSetNewBikeCapacityValue() {
//        given
        var motorcycleRepository = mock(MotorcycleRepository.class);
        var motorcycleMapper = mock(MotorcycleMapper.class);
        var motorcycleValidator = new MotorcycleValidator();
        var motorcycleService = new MotorcycleServiceImpl(motorcycleRepository, motorcycleMapper, motorcycleValidator);
        var motorcycleEntity = getMotorcycles().get(0);
//        when
        given(motorcycleRepository.findById(1L)).willReturn(Optional.of(motorcycleEntity));
        motorcycleService.editCapacity(1, 939);
//        then
        assertThat(motorcycleEntity.getCapacity(), is(939));
        assertThat(motorcycleEntity.getCapacity(), is(not(1098)));
    }

    @Test
    void shouldSetNewBikeHorsePowerValue() {
//        given
        var motorcycleRepository = mock(MotorcycleRepository.class);
        var motorcycleMapper = mock(MotorcycleMapper.class);
        var motorcycleValidator = new MotorcycleValidator();
        var motorcycleService = new MotorcycleServiceImpl(motorcycleRepository, motorcycleMapper, motorcycleValidator);
        var motorcycleEntity = getMotorcycles().get(0);
//        when
        given(motorcycleRepository.findById(1L)).willReturn(Optional.of(motorcycleEntity));
        motorcycleService.editHorsePower(1, 167);
//        then
        assertThat(motorcycleEntity.getHorsePower(), is(167));
        assertThat(motorcycleEntity.getHorsePower(), is(not(224)));
    }


    private List<MotorcycleEntity> getMotorcycles() {
        PrepareTestData prepareBikeData = new PrepareTestData();
        return prepareBikeData.motorcycles();
    }
}