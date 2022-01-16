package pl.grzegorz.motorcycle.dto.motorcycle;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MotorcycleDtoInfo {

    private long id;
    private String brand;
    private String model;
    private int year;
    private int capacity;
    private int horsePower;
    private String serialNumber;
}
