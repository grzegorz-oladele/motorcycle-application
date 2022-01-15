package pl.grzegorz.motorcycle.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "motorcycles")
@Getter
@Setter
public class MotorcycleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceLapId")
    private long id;
    private String brand;
    private String model;
    private int year;
    private int capacity;
    private int horsePower;
    private String serialNumber;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

    @PrePersist
    public void create() {
        createdOn = LocalDateTime.now();
    }

    @PreUpdate
    private void update() {
        updatedOn = LocalDateTime.now();
    }
}
