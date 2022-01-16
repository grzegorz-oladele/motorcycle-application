package pl.grzegorz.motorcycle.builder.circuit;

import pl.grzegorz.motorcycle.model.CircuitEntity;

public class CircuitEntityBuilder {

    private long id;
    private String name;
    private String city;
    private int length;

    public CircuitEntityBuilder withId(long id) {
        this.id = id;
        return this;
    }

    public CircuitEntityBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public CircuitEntityBuilder withCity(String city) {
        this.city = city;
        return this;
    }

    public CircuitEntityBuilder withLength(int length) {
        this.length = length;
        return this;
    }

    public CircuitEntity build() {
        var circuitEntity = new CircuitEntity();
        circuitEntity.setId(id);
        circuitEntity.setName(name);
        circuitEntity.setCity(city);
        circuitEntity.setLength(length);
        return circuitEntity;
    }
}
