package pl.grzegorz.motorcycle.dto.biker;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BikerDto {

    private String name;
    @NotNull
    private String email;
}
