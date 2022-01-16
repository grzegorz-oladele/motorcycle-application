package pl.grzegorz.motorcycle.service.biker;

import org.springframework.stereotype.Component;
import pl.grzegorz.motorcycle.exception.biker.BikerError;
import pl.grzegorz.motorcycle.exception.biker.BikerException;
import pl.grzegorz.motorcycle.model.BikerEntity;

import java.util.List;

@Component
public class BikerValidator {

    protected void validationEmptyBikerList(List<BikerEntity> list) {
        if (list.isEmpty()) {
            throw new BikerException(BikerError.BIKERS_EMPTY_LIST);
        }
    }

    protected void validationBikerEmail(BikerEntity bikerEntity, List<String> listOfEmails) {
        for (String email : listOfEmails) {
            if (email.equals(bikerEntity.getEmail())) {
                throw new BikerException(BikerError.BIKER_ALREADY_EXIST);
            }
        }
    }
}
