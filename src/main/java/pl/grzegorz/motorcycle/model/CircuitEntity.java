package pl.grzegorz.motorcycle.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "circuits")
@SequenceGenerator(name = "sequenceCircuitsId", initialValue = 10000, allocationSize = 1)
@Getter
@Setter
public class CircuitEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceCircuitsId")
    private long id;
    private String name;
    private String city;
    private int length;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

    @PrePersist
    public void create() {
        createdOn = LocalDateTime.now();
    }

    @PreUpdate
    public void update() {
        updatedOn = LocalDateTime.now();
    }
}
