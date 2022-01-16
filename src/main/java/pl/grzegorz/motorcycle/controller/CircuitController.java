package pl.grzegorz.motorcycle.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.grzegorz.motorcycle.dto.circuit.CircuitDto;
import pl.grzegorz.motorcycle.dto.circuit.CircuitDtoInfo;
import pl.grzegorz.motorcycle.service.circuit.CircuitService;

import java.util.List;

@RestController
@RequestMapping("/circuits")
@RequiredArgsConstructor
public class CircuitController {

    private final CircuitService circuitService;

    @GetMapping
    public List<CircuitDtoInfo> getAllCircuits() {
        return circuitService.getAllCircuits();
    }

    @GetMapping("/{id}")
    public CircuitDtoInfo getCircuitById(@PathVariable long id) {
        return circuitService.getCircuitById(id);
    }

    @PostMapping
    public CircuitDtoInfo addCircuit(@RequestBody CircuitDto circuitDto) {
        return circuitService.addCircuit(circuitDto);
    }

    @DeleteMapping("/{id}")
    public void deleteCircuit(@PathVariable long id) {
        circuitService.removeCircuit(id);
    }

    @PatchMapping("/{id}")
    public void updateLengthCircuit(@PathVariable long id, @RequestBody CircuitDto circuitDto) {
        circuitService.editLength(id, circuitDto);
    }
}
