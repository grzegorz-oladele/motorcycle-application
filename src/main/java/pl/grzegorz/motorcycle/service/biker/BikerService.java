package pl.grzegorz.motorcycle.service.biker;

import pl.grzegorz.motorcycle.dto.biker.BikerDto;
import pl.grzegorz.motorcycle.dto.biker.BikerDtoInfo;
import pl.grzegorz.motorcycle.model.BikerEntity;

import java.util.List;

public interface BikerService {

    List<BikerDtoInfo> getAllBikers();

    BikerDtoInfo getBikerById(long id);

    BikerEntity getBikerEntity(long id);

    BikerDtoInfo addBiker(BikerDto bikerDto);

    void removeBiker(long id);

    void addMotorcycle(long bikerId, long bikeId);
}
