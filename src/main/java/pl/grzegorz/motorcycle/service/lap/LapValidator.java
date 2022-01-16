package pl.grzegorz.motorcycle.service.lap;

import org.springframework.stereotype.Component;
import pl.grzegorz.motorcycle.exception.lap.LapError;
import pl.grzegorz.motorcycle.exception.lap.LapException;
import pl.grzegorz.motorcycle.model.LapEntity;

import java.util.List;

@Component
public class LapValidator {

    protected void validateEmptyList(List<LapEntity> laps) {
        if (laps.isEmpty()) {
            throw new LapException(LapError.LAP_EMPTY_LIST);
        }
    }
}
