package pl.grzegorz.motorcycle.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "bikers")
@Getter
@Setter
public class BikerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceBikersId")
    private long id;
    private String name;
    private String email;
    private boolean isActive = true;
    @OneToMany(cascade = CascadeType.REMOVE)
    private List<MotorcycleEntity> bikes = new ArrayList<>();
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
