package pl.grzegorz.motorcycle.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "laps")
@SequenceGenerator(name = "sequenceLapId", initialValue = 100, allocationSize = 1)
@Getter
@Setter
@ToString
public class LapEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceLapId")
    private long id;
    private LocalDate date;
    private String time;
    @ManyToOne
    private BikerEntity biker;
    @ManyToOne
    private CircuitEntity circuit;

    @PrePersist
    public void create() {
        date = LocalDate.now();
    }
}
