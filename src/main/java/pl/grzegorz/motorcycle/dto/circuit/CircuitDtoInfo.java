package pl.grzegorz.motorcycle.dto.circuit;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class CircuitDtoInfo {

    private long id;
    private String name;
    private String city;
    private int length;
}
