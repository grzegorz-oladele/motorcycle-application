package pl.grzegorz.motorcycle.service.lap;

import pl.grzegorz.motorcycle.dto.lap.LapDto;
import pl.grzegorz.motorcycle.dto.lap.LapDtoInfo;

import java.util.List;

public interface LapService {

    LapDtoInfo addLap(long bikerId, long circuitId, LapDto lapDto);

    List<LapDtoInfo> getAllLaps();

    List<LapDtoInfo> getAllLapsByBiker(long bikerId);

    List<LapDtoInfo> getAllLapsByDateAndCircuit(String startDate, String endDate, long circuitId);
}
