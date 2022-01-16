package pl.grzegorz.motorcycle.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.grzegorz.motorcycle.dto.biker.BikerDto;
import pl.grzegorz.motorcycle.dto.biker.BikerDtoInfo;
import pl.grzegorz.motorcycle.service.biker.BikerService;

import java.util.List;

@RestController
@RequestMapping("/bikers")
@RequiredArgsConstructor
public class BikerController {

    private final BikerService bikerService;

    @GetMapping
    public List<BikerDtoInfo> getAllBikers() {
        return bikerService.getAllBikers();
    }

    @GetMapping("/{id}")
    public BikerDtoInfo getBikerById(@PathVariable long id) {
        return bikerService.getBikerById(id);
    }

    @PostMapping
    public BikerDtoInfo addBiker(@RequestBody BikerDto bikerDto) {
        return bikerService.addBiker(bikerDto);
    }

    @PatchMapping("/{id}")
    public void removeBiker(@PathVariable long id) {
        bikerService.removeBiker(id);
    }

    @PatchMapping("/{bikerId}/bikes/{bikeId}")
    public void motorcycleOwner(@PathVariable long bikerId, @PathVariable long bikeId) {
        bikerService.addMotorcycle(bikerId, bikeId);
    }
}
