package pl.grzegorz.motorcycle.mapper;

import org.springframework.stereotype.Component;
import pl.grzegorz.motorcycle.builder.circuit.CircuitDtoInfoBuilder;
import pl.grzegorz.motorcycle.builder.circuit.CircuitEntityBuilder;
import pl.grzegorz.motorcycle.dto.circuit.CircuitDto;
import pl.grzegorz.motorcycle.dto.circuit.CircuitDtoInfo;
import pl.grzegorz.motorcycle.model.CircuitEntity;

import java.util.Objects;

@Component
public class CircuitMapper {

    public CircuitEntity fromDtoToEntity(CircuitDto dto) {
        if (dto == null) {
            return null;
        }
        var circuitBuilder = new CircuitEntityBuilder();
        if (Objects.nonNull(dto.getCity())) {
            circuitBuilder.withCity(dto.getCity());
        }
        if (Objects.nonNull(dto.getName())) {
            circuitBuilder.withName(dto.getName());
        }
        if (dto.getLength() > 0) {
            circuitBuilder.withLength(dto.getLength());
        }
        return circuitBuilder.build();
    }

    public CircuitDtoInfo fromEntityToDtoInfo(CircuitEntity entity) {
        if (entity == null) {
            return null;
        }
        var circuitBuilder = new CircuitDtoInfoBuilder();
        if (entity.getId() > 0) {
            circuitBuilder.withId(entity.getId());
        }
        if (Objects.nonNull(entity.getName())) {
            circuitBuilder.withName(entity.getName());
        }
        if (Objects.nonNull(entity.getCity())) {
            circuitBuilder.withCity(entity.getCity());
        }
        if (entity.getLength() > 0) {
            circuitBuilder.withLength(entity.getLength());
        }
        return circuitBuilder.buildInfo();
    }
}
