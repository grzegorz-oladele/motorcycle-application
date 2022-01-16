package pl.grzegorz.motorcycle.builder.biker;

import pl.grzegorz.motorcycle.model.BikerEntity;

public class BikerEntityBuilder {

    private long id;
    private String name;
    private String email;

    public BikerEntityBuilder withId(long id) {
        this.id = id;
        return this;
    }

    public BikerEntityBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public BikerEntityBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public BikerEntity build() {
        BikerEntity bikerEntity = new BikerEntity();
        bikerEntity.setId(id);
        bikerEntity.setName(name);
        bikerEntity.setEmail(email);
        return bikerEntity;
    }
}
