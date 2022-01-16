package pl.grzegorz.motorcycle.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.grzegorz.motorcycle.builder.biker.BikerDtoInfoBuilder;
import pl.grzegorz.motorcycle.builder.biker.BikerEntityBuilder;
import pl.grzegorz.motorcycle.dto.biker.BikerDto;
import pl.grzegorz.motorcycle.dto.biker.BikerDtoInfo;
import pl.grzegorz.motorcycle.dto.motorcycle.MotorcycleDtoInfo;
import pl.grzegorz.motorcycle.model.BikerEntity;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class BikerMapper {

    private final MotorcycleMapper motorcycleMapper;

    public BikerEntity fromDtoToEntity(BikerDto bikerDto) {
        if (bikerDto == null) {
            return null;
        }
        BikerEntityBuilder bikerBuilder = new BikerEntityBuilder();
        if (Objects.nonNull(bikerDto.getName())) {
            bikerBuilder.withName(bikerDto.getName());
        }
        return bikerBuilder.build();
    }

    public BikerDtoInfo fromEntityToDtoInfo(BikerEntity bikerEntity) {
        if (bikerEntity == null) {
            return null;
        }
        BikerDtoInfoBuilder bikerBuilder = new BikerDtoInfoBuilder();
        if (bikerEntity.getId() > 0) {
            bikerBuilder.withId(bikerEntity.getId());
        }
        if (Objects.nonNull(bikerEntity.getName())) {
            bikerBuilder.withName(bikerEntity.getName());
        }
        if (Objects.nonNull(bikerEntity.getBikes())) {
            bikerBuilder.withBikes(getListOfMotorcyclesDtoInfo(bikerEntity));
        }
        return bikerBuilder.buildInfo();
    }

    private List<MotorcycleDtoInfo> getListOfMotorcyclesDtoInfo(BikerEntity bikerEntity) {
        return bikerEntity.getBikes().stream()
                .map(motorcycleMapper::fromEntityToDtoInfo)
                .collect(Collectors.toList());
    }
}
