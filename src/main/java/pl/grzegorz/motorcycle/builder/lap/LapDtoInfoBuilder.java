package pl.grzegorz.motorcycle.builder.lap;

import pl.grzegorz.motorcycle.dto.biker.BikerDtoInfo;
import pl.grzegorz.motorcycle.dto.circuit.CircuitDtoInfo;
import pl.grzegorz.motorcycle.dto.lap.LapDtoInfo;

import java.time.LocalDate;

public class LapDtoInfoBuilder {

    private long id;
    private LocalDate date;
    private String time;
    private BikerDtoInfo biker;
    private CircuitDtoInfo circuit;

    public LapDtoInfoBuilder withId(long id) {
        this.id = id;
        return this;
    }

    public LapDtoInfoBuilder withDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public LapDtoInfoBuilder withTime(String time) {
        this.time = time;
        return this;
    }

    public LapDtoInfoBuilder withBiker(BikerDtoInfo biker) {
        this.biker = biker;
        return this;
    }

    public LapDtoInfoBuilder withCircuit(CircuitDtoInfo circuit) {
        this.circuit = circuit;
        return this;
    }

    public LapDtoInfo build() {
        LapDtoInfo lapDtoInfo = new LapDtoInfo();
        lapDtoInfo.setId(id);
        lapDtoInfo.setDate(date);
        lapDtoInfo.setTime(time);
        lapDtoInfo.setBiker(biker);
        lapDtoInfo.setCircuit(circuit);
        return lapDtoInfo;
    }
}
