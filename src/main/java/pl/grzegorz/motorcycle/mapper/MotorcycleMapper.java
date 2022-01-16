package pl.grzegorz.motorcycle.mapper;

import org.springframework.stereotype.Component;
import pl.grzegorz.motorcycle.builder.MotorcycleDtoInfoBuilder;
import pl.grzegorz.motorcycle.builder.MotorcycleEntityBuilder;
import pl.grzegorz.motorcycle.dto.MotorcycleDto;
import pl.grzegorz.motorcycle.dto.MotorcycleDtoInfo;
import pl.grzegorz.motorcycle.model.MotorcycleEntity;

import java.util.Objects;

@Component
public class MotorcycleMapper {

    public MotorcycleEntity fromDtoToEntity(MotorcycleDto motorcycleDto) {
        if (motorcycleDto == null) {
            return null;
        }
        MotorcycleEntityBuilder motorcycleEnityBuilder = new MotorcycleEntityBuilder();
        if (Objects.nonNull(motorcycleDto.getBrand())) {
            motorcycleEnityBuilder.withBrand(motorcycleDto.getBrand());
        }
        if (Objects.nonNull(motorcycleDto.getModel())) {
            motorcycleEnityBuilder.withModel(motorcycleDto.getModel());
        }
        if (motorcycleDto.getYear() > 0) {
            motorcycleEnityBuilder.withYear(motorcycleDto.getYear());
        }
        if (motorcycleDto.getCapacity() > 0) {
            motorcycleEnityBuilder.withCapacity(motorcycleDto.getCapacity());
        }
        if (motorcycleDto.getHorsePower() > 0) {
            motorcycleEnityBuilder.withHorsePower(motorcycleDto.getHorsePower());
        }
        if (Objects.nonNull(motorcycleDto.getSerialNumber())) {
            motorcycleEnityBuilder.withSerialNumber(motorcycleDto.getSerialNumber());
        }
        return motorcycleEnityBuilder.build();
    }

    public MotorcycleDtoInfo fromEntityToDtoInfo(MotorcycleEntity motorcycleEntity) {
        if (motorcycleEntity == null) {
            return null;
        }
        MotorcycleDtoInfoBuilder motorcycleDtoInfoBuilder = new MotorcycleDtoInfoBuilder();
        if (motorcycleEntity.getId() > 0) {
            motorcycleDtoInfoBuilder.withId(motorcycleEntity.getId());
        }
        if (Objects.nonNull(motorcycleEntity.getBrand())) {
            motorcycleDtoInfoBuilder.withBrand(motorcycleEntity.getBrand());
        }
        if (Objects.nonNull(motorcycleEntity.getModel())) {
            motorcycleDtoInfoBuilder.withModel(motorcycleEntity.getModel());
        }
        if (motorcycleEntity.getYear() > 1900) {
            motorcycleDtoInfoBuilder.withYear(motorcycleEntity.getYear());
        }
        if (motorcycleEntity.getCapacity() > 0) {
            motorcycleDtoInfoBuilder.withCapacity(motorcycleEntity.getCapacity());
        }
        if (motorcycleEntity.getHorsePower() > 0) {
            motorcycleDtoInfoBuilder.withHorsePower(motorcycleEntity.getHorsePower());
        }
        if (Objects.nonNull(motorcycleEntity.getSerialNumber())) {
            motorcycleDtoInfoBuilder.withSerialNumber(motorcycleEntity.getSerialNumber());
        }
        return motorcycleDtoInfoBuilder.buildInfo();
    }
}
