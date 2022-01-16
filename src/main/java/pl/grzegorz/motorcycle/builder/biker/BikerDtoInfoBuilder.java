package pl.grzegorz.motorcycle.builder.biker;

import pl.grzegorz.motorcycle.dto.biker.BikerDtoInfo;
import pl.grzegorz.motorcycle.dto.motorcycle.MotorcycleDtoInfo;

import java.util.List;

public class BikerDtoInfoBuilder {

    private long id;
    private String username;
    private List<MotorcycleDtoInfo> motorcycles;

    public BikerDtoInfoBuilder withId(long id) {
        this.id = id;
        return this;
    }

    public BikerDtoInfoBuilder withName(String username) {
        this.username = username;
        return this;
    }

    public BikerDtoInfoBuilder withBikes(List<MotorcycleDtoInfo> motorcycles) {
        this.motorcycles = motorcycles;
        return this;
    }

    public BikerDtoInfo buildInfo() {
        var bikerDtoInfo = new BikerDtoInfo();
        bikerDtoInfo.setId(id);
        bikerDtoInfo.setUsername(username);
        bikerDtoInfo.setBikes(motorcycles);
        return bikerDtoInfo;
    }
}
