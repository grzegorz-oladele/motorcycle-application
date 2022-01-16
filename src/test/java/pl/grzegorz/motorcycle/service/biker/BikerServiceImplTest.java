package pl.grzegorz.motorcycle.service.biker;

import org.junit.jupiter.api.Test;
import pl.grzegorz.motorcycle.PrepareTestData;
import pl.grzegorz.motorcycle.mapper.BikerMapper;
import pl.grzegorz.motorcycle.model.BikerEntity;
import pl.grzegorz.motorcycle.model.MotorcycleEntity;
import pl.grzegorz.motorcycle.repository.BikerRepository;
import pl.grzegorz.motorcycle.repository.MotorcycleRepository;
import pl.grzegorz.motorcycle.service.motorcycle.MotorcycleValidator;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class BikerServiceImplTest {

    @Test
    void shouldSetBikerActiveStatusAsFalse() {
//        given
        var bikerRepository = mock(BikerRepository.class);
        var motorcycleRepository = mock(MotorcycleRepository.class);
        var bikerMapper = mock(BikerMapper.class);
        var bikerValidator = mock(BikerValidator.class);
        var motorcycleValidator = mock(MotorcycleValidator.class);
        var bikeService = new BikerServiceImpl(bikerRepository, motorcycleRepository, bikerMapper, bikerValidator,
                motorcycleValidator);
        BikerEntity biker = getBikers().get(0);
//        when
        given(bikerRepository.findById(1L)).willReturn(Optional.of(biker));
        bikeService.removeBiker(1);
//        then
        assertThat(biker.isActive(), is(false));
    }

    @Test
    void shouldAddBikeToBikeBikerList() {
        //        given
        var bikerRepository = mock(BikerRepository.class);
        var motorcycleRepository = mock(MotorcycleRepository.class);
        var bikerMapper = mock(BikerMapper.class);
        var bikerValidator = mock(BikerValidator.class);
        var motorcycleValidator = mock(MotorcycleValidator.class);
        var bikeService = new BikerServiceImpl(bikerRepository, motorcycleRepository, bikerMapper, bikerValidator,
                motorcycleValidator);
        var biker = getBikers().get(0);
        var motorcycle = getBikes().get(0);
//        when
        given(bikerRepository.findById(1L)).willReturn(Optional.of(biker));
        given(motorcycleRepository.findById(3L)).willReturn(Optional.of(motorcycle));
        bikeService.addMotorcycle(1, 3);
//        then
        assertThat(biker.getBikes().size(), is(1));
        assertThat(biker.getBikes().get(0).getSerialNumber(), is("uh892368134y8hi7yr4b1idh9823789uh"));
    }

    private List<BikerEntity> getBikers() {
        PrepareTestData prepareTestData = new PrepareTestData();
        return prepareTestData.bikers();
    }

    private List<MotorcycleEntity> getBikes() {
        PrepareTestData prepareTestData = new PrepareTestData();
        return prepareTestData.motorcycles();
    }
}