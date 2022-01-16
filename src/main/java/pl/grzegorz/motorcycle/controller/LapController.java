package pl.grzegorz.motorcycle.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.grzegorz.motorcycle.dto.lap.LapDto;
import pl.grzegorz.motorcycle.dto.lap.LapDtoInfo;
import pl.grzegorz.motorcycle.service.lap.LapService;

import java.util.List;

@RestController
@RequestMapping("/laps")
@RequiredArgsConstructor
public class LapController {

    private final LapService lapService;

    @GetMapping
    public List<LapDtoInfo> getAllLaps() {
        return lapService.getAllLaps();
    }

    @PostMapping("/bikers/{bikerId}/circuits/{circuitId}")
    public LapDtoInfo addLap(@PathVariable long bikerId, @PathVariable long circuitId, @RequestBody LapDto lapDto) {
        return lapService.addLap(bikerId, circuitId, lapDto);
    }

    @GetMapping("/bikers/{bikerId}")
    public List<LapDtoInfo> getAllLapsByBiker(@PathVariable long bikerId) {
        return lapService.getAllLapsByBiker(bikerId);
    }

    @GetMapping("/circuits/{circuitId}")
    public List<LapDtoInfo> getAllLapsByDateAndCircuit(@RequestParam String startDate, @RequestParam String endDate,
                                                       @PathVariable long circuitId) {
        return lapService.getAllLapsByDateAndCircuit(startDate,endDate,circuitId);
    }
}
