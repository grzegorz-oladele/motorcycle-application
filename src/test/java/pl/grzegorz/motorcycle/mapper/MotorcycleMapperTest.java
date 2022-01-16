package pl.grzegorz.motorcycle.mapper;

import org.junit.jupiter.api.Test;
import pl.grzegorz.motorcycle.dto.motorcycle.MotorcycleDto;
import pl.grzegorz.motorcycle.dto.motorcycle.MotorcycleDtoInfo;
import pl.grzegorz.motorcycle.model.MotorcycleEntity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class MotorcycleMapperTest {

    @Test
    void shouldReturnNullWhenBikeDtoWillBeNull() {
//        given
        MotorcycleDto motorcycleDto = null;
        MotorcycleMapper motorcycleMapper = new MotorcycleMapper();
//        when
        MotorcycleEntity motorcycleEntity = motorcycleMapper.fromDtoToEntity(motorcycleDto);
//        then
        assertNull(motorcycleEntity);
    }

    @Test
    void shouldReturnBikeEntityWhenBikeDtoWillBeNotNull() {
//        given
        MotorcycleMapper motorcycleMapper = new MotorcycleMapper();
        MotorcycleDto bikeDto = new MotorcycleDto();
        bikeDto.setBrand("Ducati");
        bikeDto.setModel("Panigale V4");
        bikeDto.setCapacity(998);
        bikeDto.setHorsePower(224);
        bikeDto.setYear(2020);
        bikeDto.setSerialNumber("uhjncs98hubjnkdqwjnxk09onjk1dqw");
//        when
        var bikeEntity = motorcycleMapper.fromDtoToEntity(bikeDto);
//        then
        assertThat(bikeEntity, is(instanceOf(MotorcycleEntity.class)));
        assertThat(bikeEntity.getBrand(), is(bikeDto.getBrand()));
        assertThat(bikeEntity.getModel(), is(bikeDto.getModel()));
        assertThat(bikeEntity.getCapacity(), is(bikeDto.getCapacity()));
        assertThat(bikeEntity.getHorsePower(), is(bikeDto.getHorsePower()));
        assertThat(bikeEntity.getYear(), is(bikeDto.getYear()));
        assertThat(bikeEntity.getSerialNumber(), is(bikeDto.getSerialNumber()));
    }

    @Test
    void shouldReturnNullWhenBikeEntityWillBeNull() {
//        given
        MotorcycleEntity motorcycleEntity = null;
        MotorcycleMapper motorcycleMapper = new MotorcycleMapper();
//        when
        MotorcycleDtoInfo motorcycleDtoInfo = motorcycleMapper.fromEntityToDtoInfo(motorcycleEntity);
//        then
        assertNull(motorcycleDtoInfo);
    }

    @Test
    void shouldReturnBikeDtoInfoWhenBikeEntityWillBeNotNull() {
//        given
        var motorcycleMapper = new MotorcycleMapper();
        MotorcycleEntity motorcycleEntity = new MotorcycleEntity();
        motorcycleEntity.setId(10);
        motorcycleEntity.setBrand("Ducati");
        motorcycleEntity.setModel("Panigale V4");
        motorcycleEntity.setCapacity(998);
        motorcycleEntity.setHorsePower(224);
        motorcycleEntity.setYear(2020);
        motorcycleEntity.setSerialNumber("uhjncs98hubjnkdqwjnxk09onjk1dqw");
//        when
        var motorcycleDtoInfo = motorcycleMapper.fromEntityToDtoInfo(motorcycleEntity);
//        then
        assertThat(motorcycleDtoInfo, is(instanceOf(MotorcycleDtoInfo.class)));
        assertThat(motorcycleDtoInfo.getId(), is(motorcycleEntity.getId()));
        assertThat(motorcycleDtoInfo.getBrand(), is(motorcycleEntity.getBrand()));
        assertThat(motorcycleDtoInfo.getModel(), is(motorcycleEntity.getModel()));
        assertThat(motorcycleDtoInfo.getCapacity(), is(motorcycleEntity.getCapacity()));
        assertThat(motorcycleDtoInfo.getHorsePower(), is(motorcycleEntity.getHorsePower()));
        assertThat(motorcycleDtoInfo.getYear(), is(motorcycleEntity.getYear()));
        assertThat(motorcycleDtoInfo.getSerialNumber(), is(motorcycleEntity.getSerialNumber()));
    }

}