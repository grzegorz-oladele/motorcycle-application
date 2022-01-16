package pl.grzegorz.motorcycle.dto.lap;

import lombok.Getter;
import lombok.Setter;
import pl.grzegorz.motorcycle.dto.biker.BikerDtoInfo;
import pl.grzegorz.motorcycle.dto.circuit.CircuitDtoInfo;

import java.time.LocalDate;

@Getter
@Setter
public class LapDtoInfo {

    private long id;
    private LocalDate date;
    private String time;
    private BikerDtoInfo biker;
    private CircuitDtoInfo circuit;
}
