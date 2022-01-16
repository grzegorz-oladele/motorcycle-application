package pl.grzegorz.motorcycle.builder;

import pl.grzegorz.motorcycle.model.MotorcycleEntity;

import java.time.LocalDateTime;

public class MotorcycleEntityBuilder {

    private long id;
    private String brand;
    private String model;
    private int year;
    private int capacity;
    private int horsePower;
    private String serialNumber;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

    public MotorcycleEntityBuilder withId(long id) {
        this.id = id;
        return this;
    }

    public MotorcycleEntityBuilder withBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public MotorcycleEntityBuilder withModel(String model) {
        this.model = model;
        return this;
    }

    public MotorcycleEntityBuilder withYear(int year) {
        this.year = year;
        return this;
    }

    public MotorcycleEntityBuilder withCapacity(int capacity) {
        this.capacity = capacity;
        return this;
    }

    public MotorcycleEntityBuilder withSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
        return this;
    }

    public MotorcycleEntityBuilder withHorsePower(int horsePower) {
        this.horsePower = horsePower;
        return this;
    }

    public MotorcycleEntityBuilder withCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
        return this;
    }
    public MotorcycleEntityBuilder withUpdatedOn(LocalDateTime updatedOn) {
        this.updatedOn = updatedOn;
        return this;
    }

    public MotorcycleEntity build() {
        MotorcycleEntity bikeEntity = new MotorcycleEntity();
        bikeEntity.setId(id);
        bikeEntity.setBrand(brand);
        bikeEntity.setModel(model);
        bikeEntity.setYear(year);
        bikeEntity.setCapacity(capacity);
        bikeEntity.setHorsePower(horsePower);
        bikeEntity.setSerialNumber(serialNumber);
        bikeEntity.setCreatedOn(createdOn);
        bikeEntity.setUpdatedOn(updatedOn);
        return bikeEntity;
    }
}
