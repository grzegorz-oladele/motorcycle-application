package pl.grzegorz.motorcycle.builder.circuit;

import pl.grzegorz.motorcycle.dto.circuit.CircuitDtoInfo;

public class CircuitDtoInfoBuilder {

    private long id;
    private String name;
    private String city;
    private int length;

    public CircuitDtoInfoBuilder withId(long id) {
        this.id = id;
        return this;
    }

    public CircuitDtoInfoBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public CircuitDtoInfoBuilder withCity(String city) {
        this.city = city;
        return this;
    }

    public CircuitDtoInfoBuilder withLength(int length) {
        this.length = length;
        return this;
    }

    public CircuitDtoInfo buildInfo() {
        var circuitDtoInfo = new CircuitDtoInfo();
        circuitDtoInfo.setId(id);
        circuitDtoInfo.setName(name);
        circuitDtoInfo.setCity(city);
        circuitDtoInfo.setLength(length);
        return circuitDtoInfo;
    }
}
