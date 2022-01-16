package pl.grzegorz.motorcycle.builder;

import pl.grzegorz.motorcycle.dto.MotorcycleDtoInfo;

public class MotorcycleDtoInfoBuilder {

    private long id;
    private String brand;
    private String model;
    private int year;
    private int capacity;
    private int horsePower;
    private String serialNumber;

    public MotorcycleDtoInfoBuilder withId(long id) {
        this.id = id;
        return this;
    }

    public MotorcycleDtoInfoBuilder withBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public MotorcycleDtoInfoBuilder withModel(String model) {
        this.model = model;
        return this;
    }

    public MotorcycleDtoInfoBuilder withYear(int year) {
        this.year = year;
        return this;
    }

    public MotorcycleDtoInfoBuilder withCapacity(int capacity) {
        this.capacity = capacity;
        return this;
    }

    public MotorcycleDtoInfoBuilder withSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
        return this;
    }

    public MotorcycleDtoInfoBuilder withHorsePower(int horsePower) {
        this.horsePower = horsePower;
        return this;
    }

    public MotorcycleDtoInfo buildInfo() {
        MotorcycleDtoInfo bikeDtoInfo = new MotorcycleDtoInfo();
        bikeDtoInfo.setId(id);
        bikeDtoInfo.setBrand(brand);
        bikeDtoInfo.setModel(model);
        bikeDtoInfo.setYear(year);
        bikeDtoInfo.setCapacity(capacity);
        bikeDtoInfo.setHorsePower(horsePower);
        bikeDtoInfo.setSerialNumber(serialNumber);
        return bikeDtoInfo;
    }
}
