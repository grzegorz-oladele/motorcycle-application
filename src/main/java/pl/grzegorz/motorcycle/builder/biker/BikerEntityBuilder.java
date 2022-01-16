package pl.grzegorz.motorcycle.builder.biker;

import pl.grzegorz.motorcycle.model.BikerEntity;

public class BikerEntityBuilder {

    private long id;
    private String name;

    public BikerEntityBuilder withId(long id) {
        this.id = id;
        return this;
    }

    public BikerEntityBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public BikerEntity build() {
        BikerEntity bikerEntity = new BikerEntity();
        bikerEntity.setId(id);
        bikerEntity.setName(name);
        return bikerEntity;
    }
}
