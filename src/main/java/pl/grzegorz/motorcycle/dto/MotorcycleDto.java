package pl.grzegorz.motorcycle.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class MotorcycleDto {

    private String brand;
    private String model;
    private int year;
    private int capacity;
    private int horsePower;
    private String serialNumber;
}
