package pl.grzegorz.motorcycle.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.grzegorz.motorcycle.dto.motorcycle.MotorcycleDto;
import pl.grzegorz.motorcycle.dto.motorcycle.MotorcycleDtoInfo;
import pl.grzegorz.motorcycle.service.MotorcycleService;

import java.util.List;

@RestController
@RequestMapping("/motorcycles")
@RequiredArgsConstructor
public class MotorcycleController {

    private final MotorcycleService motorcycleService;

    @GetMapping("/{id}")
    public MotorcycleDtoInfo getBikeById(@PathVariable long id) {
        return motorcycleService.getMotorcycleById(id);
    }

    @GetMapping
    public List<MotorcycleDtoInfo> getAllBikes() {
        return motorcycleService.getAllMotorcycles();
    }

    @PostMapping
    public MotorcycleDtoInfo addBike(@RequestBody MotorcycleDto motorcycleDto) {
        return motorcycleService.addMotorcycle(motorcycleDto);
    }

    @DeleteMapping("/{id}")
    public void removeBike(@PathVariable long id) {
        motorcycleService.removeMotorcycle(id);
    }

    @PatchMapping("/{id}/capacity")
    public MotorcycleDtoInfo editCapacity(@PathVariable long id, @RequestParam(required = false) int capacity) {
        return motorcycleService.editCapacity(id, capacity);
    }

    @PatchMapping("/{id}/horse-power")
    public MotorcycleDtoInfo editHorsePower(@PathVariable long id, @RequestParam int power) {
        return motorcycleService.editHorsePower(id, power);
    }

    @GetMapping("/horse-power")
    public List<MotorcycleDtoInfo> getAllByHorsePower(@RequestParam int min, @RequestParam int max) {
        return motorcycleService.getAllByHorsePower(min, max);
    }

    @GetMapping("/brands")
    public List<MotorcycleDtoInfo> getAllByBrand(@RequestParam String brand) {
        return motorcycleService.getAllByBrand(brand);
    }

    @GetMapping("/models")
    public List<MotorcycleDtoInfo> getAllByModel(@RequestParam String model) {
        return motorcycleService.getAllByModel(model);
    }

    @GetMapping("/capacity")
    public List<MotorcycleDtoInfo> getAllByCapacity(@RequestParam int min, @RequestParam int max) {
        return motorcycleService.getAllByCapacity(min, max);
    }
}
