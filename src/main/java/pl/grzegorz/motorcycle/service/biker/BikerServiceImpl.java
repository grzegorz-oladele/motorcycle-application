package pl.grzegorz.motorcycle.service.biker;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.grzegorz.motorcycle.dto.biker.BikerDto;
import pl.grzegorz.motorcycle.dto.biker.BikerDtoInfo;
import pl.grzegorz.motorcycle.exception.biker.BikerError;
import pl.grzegorz.motorcycle.exception.biker.BikerException;
import pl.grzegorz.motorcycle.exception.motorcycle.MotorcycleError;
import pl.grzegorz.motorcycle.exception.motorcycle.MotorcycleException;
import pl.grzegorz.motorcycle.mapper.BikerMapper;
import pl.grzegorz.motorcycle.model.BikerEntity;
import pl.grzegorz.motorcycle.model.MotorcycleEntity;
import pl.grzegorz.motorcycle.repository.BikerRepository;
import pl.grzegorz.motorcycle.repository.MotorcycleRepository;
import pl.grzegorz.motorcycle.service.motorcycle.MotorcycleValidator;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BikerServiceImpl implements BikerService {

    private final BikerRepository bikerRepository;
    private final MotorcycleRepository motorcycleRepository;
    private final BikerMapper bikerMapper;
    private final BikerValidator bikerValidator;
    private final MotorcycleValidator motorcycleValidator;

    @Override
    public List<BikerDtoInfo> getAllBikers() {
        List<BikerEntity> list = getBikers();
        bikerValidator.validationEmptyBikerList(list);
        return toBikersDtoInfoList(list);
    }

    @Override
    public BikerDtoInfo getBikerById(long id) {
        BikerEntity bikerEntity = getBikerEntity(id);
        return bikerMapper.fromEntityToDtoInfo(bikerEntity);
    }

    @Override
    public BikerEntity getBikerEntity(long id) {
        return bikerRepository.findById(id)
                .orElseThrow(() -> new BikerException(BikerError.BIKER_NOT_FOUND));
    }

    @Override
    public BikerDtoInfo addBiker(BikerDto bikerDto) {
        BikerEntity bikerEntity = bikerMapper.fromDtoToEntity(bikerDto);
        List<String> listOfEmails = getListOfEmails();
        bikerValidator.validationBikerEmail(bikerEntity, listOfEmails);
        bikerRepository.save(bikerEntity);
        return bikerMapper.fromEntityToDtoInfo(bikerEntity);
    }

    @Override
    public void removeBiker(long id) {
        BikerEntity bikerEntity = getBikerEntity(id);
        bikerEntity.setId(id);
        bikerEntity.setActive(false);
        bikerRepository.save(bikerEntity);
    }

    @Override
    public void addMotorcycle(long bikerId, long bikeId) {
        BikerEntity bikerEntity = getBikerEntity(bikerId);
        MotorcycleEntity motorcycleEntity = getMotorcycle(bikeId);
        List<BikerEntity> bikers = getBikers();
        motorcycleValidator.validationMotorcycleExist(motorcycleEntity, bikers);
        bikerEntity.getBikes().add(motorcycleEntity);
        motorcycleRepository.save(motorcycleEntity);
    }

    private List<BikerEntity> getBikers() {
        return bikerRepository.findAll();
    }

    private MotorcycleEntity getMotorcycle(long id) {
        return motorcycleRepository.findById(id)
                .orElseThrow(() -> new MotorcycleException(MotorcycleError.MOTORCYCLE_NOT_FOUND));
    }

    private List<BikerDtoInfo> toBikersDtoInfoList(List<BikerEntity> list) {
        return list
                .stream()
                .map(bikerMapper::fromEntityToDtoInfo)
                .collect(Collectors.toList());
    }

    private List<String> getListOfEmails() {
        return bikerRepository.getBikersEmails();
    }
}
