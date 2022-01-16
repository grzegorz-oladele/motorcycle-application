package pl.grzegorz.motorcycle.service.motorcycle;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.grzegorz.motorcycle.dto.motorcycle.MotorcycleDto;
import pl.grzegorz.motorcycle.dto.motorcycle.MotorcycleDtoInfo;
import pl.grzegorz.motorcycle.exception.motorcycle.MotorcycleError;
import pl.grzegorz.motorcycle.exception.motorcycle.MotorcycleException;
import pl.grzegorz.motorcycle.mapper.MotorcycleMapper;
import pl.grzegorz.motorcycle.model.MotorcycleEntity;
import pl.grzegorz.motorcycle.repository.MotorcycleRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MotorcycleServiceImpl implements MotorcycleService {

    private final MotorcycleRepository motorcycleRepository;
    private final MotorcycleMapper motorcycleMapper;
    private final MotorcycleValidator motorcycleValidator;


    @Override
    public MotorcycleDtoInfo getMotorcycleById(long id) {
        MotorcycleEntity motorcycleEntity = getMotorcycleEntity(id);
        return motorcycleMapper.fromEntityToDtoInfo(motorcycleEntity);
    }

    @Override
    public List<MotorcycleDtoInfo> getAllMotorcycles() {
        List<MotorcycleEntity> list = motorcycleRepository.findAll();
        motorcycleValidator.validationEmptyMotorcycleList(list);
        return toMotorcycleDtoInfoList(list);
    }

    @Override
    public MotorcycleDtoInfo addMotorcycle(MotorcycleDto motorcycleDto) {
        MotorcycleEntity motorcycleEntity = motorcycleMapper.fromDtoToEntity(motorcycleDto);
        List<String> serialNumbers = motorcycleRepository.findAllSerialNumbers();
        motorcycleValidator.validationSerialNumber(motorcycleEntity, serialNumbers);
        motorcycleRepository.save(motorcycleEntity);
        return motorcycleMapper.fromEntityToDtoInfo(motorcycleEntity);
    }

    @Override
    public void removeMotorcycle(long id) {
        MotorcycleEntity motorcycleEntity = getMotorcycleEntity(id);
        motorcycleRepository.delete(motorcycleEntity);
    }

    @Override
    public MotorcycleDtoInfo editCapacity(long id, int capacity) {
        MotorcycleEntity motorcycleEntity = getMotorcycleEntity(id);
        motorcycleEntity.setCapacity(capacity);
        motorcycleRepository.save(motorcycleEntity);
        return motorcycleMapper.fromEntityToDtoInfo(motorcycleEntity);
    }

    @Override
    public MotorcycleDtoInfo editHorsePower(long id, int horsePower) {
        MotorcycleEntity motorcycleEntity = getMotorcycleEntity(id);
        motorcycleEntity.setCapacity(horsePower);
        motorcycleRepository.save(motorcycleEntity);
        return motorcycleMapper.fromEntityToDtoInfo(motorcycleEntity);
    }

    @Override
    public List<MotorcycleDtoInfo> getAllByHorsePower(int min, int max) {
        List<MotorcycleEntity> list = motorcycleRepository.listOfBikesByHorsePower(min, max);
        motorcycleValidator.validationEmptyMotorcycleList(list);
        return toMotorcycleDtoInfoList(list);
    }

    @Override
    public List<MotorcycleDtoInfo> getAllByBrand(String brand) {
        var list = motorcycleRepository.listOfBikesByBrand(brand);
        motorcycleValidator.validationEmptyMotorcycleList(list);
        return toMotorcycleDtoInfoList(list);
    }

    @Override
    public List<MotorcycleDtoInfo> getAllByModel(String model) {
        List<MotorcycleEntity> list = motorcycleRepository.listOfBikesByModel(model);
        motorcycleValidator.validationEmptyMotorcycleList(list);
        return toMotorcycleDtoInfoList(list);
    }

    @Override
    public List<MotorcycleDtoInfo> getAllByCapacity(int min, int max) {
        List<MotorcycleEntity> list = motorcycleRepository.listOfBikesByCapacity(min, max);
        motorcycleValidator.validationEmptyMotorcycleList(list);
        return toMotorcycleDtoInfoList(list);
    }

    private MotorcycleEntity getMotorcycleEntity(long id) {
        return motorcycleRepository.findById(id)
                .orElseThrow(() -> new MotorcycleException(MotorcycleError.MOTORCYCLE_NOT_FOUND));
    }

    private List<MotorcycleDtoInfo> toMotorcycleDtoInfoList(List<MotorcycleEntity> list) {
        return list
                .stream()
                .map(motorcycleMapper::fromEntityToDtoInfo)
                .collect(Collectors.toList());
    }
}
