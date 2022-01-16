package pl.grzegorz.motorcycle.mapper;

import org.junit.jupiter.api.Test;
import pl.grzegorz.motorcycle.dto.biker.BikerDto;
import pl.grzegorz.motorcycle.dto.biker.BikerDtoInfo;
import pl.grzegorz.motorcycle.model.BikerEntity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class BikerMapperTest {

    @Test
    void shouldReturnNullWhenBikerDtoWillBeNull() {
//        given
        var motorcycleMapper = mock(MotorcycleMapper.class);
        BikerDto bikerDto = null;
        var bikerMapper = new BikerMapper(motorcycleMapper);
//        when
        var bikerEntity = bikerMapper.fromDtoToEntity(bikerDto);
//        then
        assertNull(bikerEntity);
    }

    @Test
    void shouldReturnBikerEntityWhenBikerDtoWillBeNotNull() {
//        given
        var motorcycleMapper = mock(MotorcycleMapper.class);

        var bikerDto = new BikerDto();
        bikerDto.setName("Valentino Rossi");
        var bikerMapper = new BikerMapper(motorcycleMapper);
//        when
        var bikerEntity = bikerMapper.fromDtoToEntity(bikerDto);
//        then
        assertThat(bikerEntity, is(instanceOf(BikerEntity.class)));
        assertThat(bikerEntity.getName(), is(bikerDto.getName()));
    }

    @Test
    void shouldReturnNullWhenBikerEntityWillBeNull() {
//        given
        var motorcycleMapper = mock(MotorcycleMapper.class);

        BikerEntity bikerEntity = null;
        var bikerMapper = new BikerMapper(motorcycleMapper);
//        when
        var bikerDtoInfo = bikerMapper.fromEntityToDtoInfo(bikerEntity);
//        then
        assertNull(bikerDtoInfo);
    }

    @Test
    void shouldReturnBikerDtoInfoWhenBikerEntityWillBeNotNull() {
//        given
        var motorcycleMapper = mock(MotorcycleMapper.class);
        var bikerEntity = new BikerEntity();
        bikerEntity.setId(5);
        bikerEntity.setName("Valentino Rossi");
        var bikerMapper = new BikerMapper(motorcycleMapper);
//        when
        var bikerDtoInfo = bikerMapper.fromEntityToDtoInfo(bikerEntity);
//        then
        assertThat(bikerDtoInfo, is(instanceOf(BikerDtoInfo.class)));
        assertThat(bikerDtoInfo.getId(), is(bikerEntity.getId()));
        assertThat(bikerDtoInfo.getUsername(), is(bikerEntity.getName()));
    }
}