package pl.grzegorz.motorcycle.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.grzegorz.motorcycle.builder.lap.LapDtoInfoBuilder;
import pl.grzegorz.motorcycle.builder.lap.LapEntityBuilder;
import pl.grzegorz.motorcycle.dto.lap.LapDto;
import pl.grzegorz.motorcycle.dto.lap.LapDtoInfo;
import pl.grzegorz.motorcycle.model.LapEntity;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class LapMapper {

    private final BikerMapper bikerMapper;
    private final CircuitMapper circuitMapper;

    public LapEntity fromDtoToEntity(LapDto lapDto) {
        if (lapDto == null) {
            return null;
        }
        LapEntityBuilder lapBuilder = new LapEntityBuilder();
        if (Objects.nonNull(lapDto.getTime())) {
            lapBuilder.withTime(lapDto.getTime());
        }
        return lapBuilder.build();
    }

    public LapDtoInfo formEntityToDtoInfo(LapEntity lapEntity) {
        if (lapEntity == null) {
            return null;
        }
        LapDtoInfoBuilder lapBuilder = new LapDtoInfoBuilder();
        if (lapEntity.getId() > 0) {
            lapBuilder.withId(lapEntity.getId());
        }
        if (Objects.nonNull(lapEntity.getDate())) {
            lapBuilder.withDate(lapEntity.getDate());
        }
        if (Objects.nonNull(lapEntity.getTime())) {
            lapBuilder.withTime(lapEntity.getTime());
        }
        if (Objects.nonNull(lapEntity.getBiker())) {
            lapBuilder.withBiker(bikerMapper.fromEntityToDtoInfo(lapEntity.getBiker()));
        }
        if (Objects.nonNull(lapEntity.getCircuit())) {
            lapBuilder.withCircuit(circuitMapper.fromEntityToDtoInfo(lapEntity.getCircuit()));
        }
        return lapBuilder.build();
    }
}
