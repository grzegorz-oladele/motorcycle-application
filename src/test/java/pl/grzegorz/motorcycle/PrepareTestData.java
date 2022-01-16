package pl.grzegorz.motorcycle;

import pl.grzegorz.motorcycle.model.BikerEntity;
import pl.grzegorz.motorcycle.model.CircuitEntity;
import pl.grzegorz.motorcycle.model.LapEntity;
import pl.grzegorz.motorcycle.model.MotorcycleEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PrepareTestData {

    public List<BikerEntity> bikers() {
        List<BikerEntity> list = new ArrayList<>();
        BikerEntity biker1 = new BikerEntity();
        biker1.setId(1);
        biker1.setName("Valentino Rossi");
        biker1.setEmail("valentino-rossi123@123.pl");

        BikerEntity biker2 = new BikerEntity();
        biker2.setId(2);
        biker2.setName("Marc Marquez");
        biker2.setEmail("marc-marquez123@123.pl");

        BikerEntity biker3 = new BikerEntity();
        biker3.setId(3);
        biker3.setName("Fabio_Quartararo");
        biker3.setEmail("fabio-quartararo123@123.pl");

        list.add(biker1);
        list.add(biker2);
        list.add(biker3);
        return list;
    }

    public List<String> emails() {
        return bikers()
                .stream()
                .map(BikerEntity::getEmail)
                .collect(Collectors.toList());
    }

    public List<MotorcycleEntity> bikes() {
        List<MotorcycleEntity> list = new ArrayList<>();
        MotorcycleEntity bike1 = new MotorcycleEntity();
        bike1.setBrand("Ducati");
        bike1.setModel("Panigale V4S");
        bike1.setCapacity(1098);
        bike1.setHorsePower(224);
        bike1.setYear(2020);
        bike1.setSerialNumber("uh892368134y8hi7yr4b1idh9823789uh");

        MotorcycleEntity bike2 = new MotorcycleEntity();
        bike2.setBrand("BMW");
        bike2.setModel("S1000RR");
        bike2.setCapacity(999);
        bike2.setHorsePower(211);
        bike2.setYear(2021);
        bike2.setSerialNumber("48RHIUUI23INJW989823BDJK92");

        MotorcycleEntity bike3 = new MotorcycleEntity();
        bike3.setBrand("MV Agusta");
        bike3.setModel("F4");
        bike3.setCapacity(1098);
        bike3.setHorsePower(203);
        bike3.setYear(2012);
        bike3.setSerialNumber("H98134HUIIUQ89134BIUCNU892DN8743BUFI3");

        list.add(bike1);
        list.add(bike2);
        list.add(bike3);

        return list;
    }

    public List<String> serialNumbers() {
        return bikes()
                .stream()
                .map(MotorcycleEntity::getSerialNumber)
                .collect(Collectors.toList());
    }

    public List<CircuitEntity> circuits() {
        List<CircuitEntity> list = new ArrayList<>();
        CircuitEntity circuit1 = new CircuitEntity();
        circuit1.setName("Masyrak Circuit");
        circuit1.setCity("Brno");
        circuit1.setLength(5400);

        CircuitEntity circuit2 = new CircuitEntity();
        circuit2.setName("Tor Modlin");
        circuit2.setCity("Modlin");
        circuit2.setLength(1200);

        CircuitEntity circuit3 = new CircuitEntity();
        circuit3.setName("Tor Poznań");
        circuit3.setCity("Przeźmierowo");
        circuit3.setLength(4000);

        list.add(circuit1);
        list.add(circuit2);
        list.add(circuit3);

        return list;
    }

    public List<LapEntity> laps() {
        List<LapEntity> list = new ArrayList<>();
        LapEntity lap1 = new LapEntity();
        lap1.setTime("1:33:456");

        LapEntity lap2 = new LapEntity();
        lap1.setTime("1:22:467");

        LapEntity lap3 = new LapEntity();
        lap1.setTime("1:56:421");

        list.add(lap1);
        list.add(lap2);
        list.add(lap3);

        return list;
    }
}
