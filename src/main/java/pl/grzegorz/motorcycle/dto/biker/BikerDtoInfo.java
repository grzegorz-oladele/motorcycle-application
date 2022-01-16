package pl.grzegorz.motorcycle.dto.biker;

import lombok.Getter;
import lombok.Setter;
import pl.grzegorz.motorcycle.dto.motorcycle.MotorcycleDtoInfo;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class BikerDtoInfo {

    private long id;
    private String username;
    private List<MotorcycleDtoInfo> bikes = new ArrayList<>();

}
