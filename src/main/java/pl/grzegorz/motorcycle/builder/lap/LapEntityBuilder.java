package pl.grzegorz.motorcycle.builder.lap;

import pl.grzegorz.motorcycle.model.BikerEntity;
import pl.grzegorz.motorcycle.model.CircuitEntity;
import pl.grzegorz.motorcycle.model.LapEntity;

import java.time.LocalDate;

public class LapEntityBuilder {

    private long id;
    private LocalDate date;
    private String time;
    private BikerEntity biker;
    private CircuitEntity circuit;

    public LapEntityBuilder withId(long id) {
        this.id = id;
        return this;
    }

//    public LapEntityBuilder withDate(LocalDate date) {
//        this.date = date;
//        return this;
//    }

    public LapEntityBuilder withTime(String time) {
        this.time = time;
        return this;
    }

//    public LapEntityBuilder withBiker(BikerEntity biker) {
//        this.biker = biker;
//        return this;
//    }

//    public LapEntityBuilder withCircuit(CircuitEntity circuit) {
//        this.circuit = circuit;
//        return this;
//    }

    public LapEntity build() {
        LapEntity lapEntity = new LapEntity();
        lapEntity.setId(id);
        lapEntity.setTime(time);
        lapEntity.setDate(date);
        lapEntity.setBiker(biker);
        lapEntity.setCircuit(circuit);
        return lapEntity;
    }
}
