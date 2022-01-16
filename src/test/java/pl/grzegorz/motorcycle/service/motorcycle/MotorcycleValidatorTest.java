package pl.grzegorz.motorcycle.service.motorcycle;

import org.junit.jupiter.api.Test;
import pl.grzegorz.motorcycle.PrepareTestData;
import pl.grzegorz.motorcycle.exception.motorcycle.MotorcycleError;
import pl.grzegorz.motorcycle.exception.motorcycle.MotorcycleException;
import pl.grzegorz.motorcycle.model.BikerEntity;
import pl.grzegorz.motorcycle.model.MotorcycleEntity;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class MotorcycleValidatorTest {

    @Test
    void ShouldThrowBikeExceptionWhenListOfBikesIsEmpty() {
//        given
        List<MotorcycleEntity> list = Collections.emptyList();
        MotorcycleValidator motorcycleValidator = new MotorcycleValidator();
//        when + then
        assertThrows(MotorcycleException.class, () -> motorcycleValidator.validationEmptyMotorcycleList(list));
        assertEquals("Motorcycles with the specified parameters not found",
                new MotorcycleException(MotorcycleError.MOTORCYCLE_EMPTY_LIST).getMotorcycleError().getMessage());
    }

    @Test
    void shouldReturnMessageWhenListOfBikesIsNotEmpty() {
//        given
        List<MotorcycleEntity> list = getMotorcycles();
        MotorcycleValidator motorcycleValidator = new MotorcycleValidator();
//        when
        motorcycleValidator.validationEmptyMotorcycleList(list);
//        then
        System.out.println("The validateEmptyList() method did not throw an exception. The test passed");
    }

    @Test
    void shouldReturnMessageWhenBikeIsNotFound() {
//        given
        List<String> serialNumbers = getSerialNumbers();
        MotorcycleEntity motorcycleEntity = new MotorcycleEntity();
        motorcycleEntity.setSerialNumber("bhj8943bbjkvh88hhu2rfbiuiu89huir2jf");
        MotorcycleValidator motorcycleValidator = new MotorcycleValidator();
//        when
        motorcycleValidator.validationSerialNumber(motorcycleEntity, serialNumbers);
//        then
        System.out.println("The validateSerialNumber() method did not throw an exception. The test passed");
    }

    @Test
    void shouldThrowExceptionWhenSerialNumberWillBeFound() {
//        given
        List<String> serialNumbers = getSerialNumbers();
        MotorcycleValidator motorcycleValidator = new MotorcycleValidator();
        MotorcycleEntity motorcycleEntity = new MotorcycleEntity();
        motorcycleEntity.setSerialNumber("uh892368134y8hi7yr4b1idh9823789uh");
//        when + then
        assertThrows(MotorcycleException.class, () -> motorcycleValidator.validationSerialNumber(motorcycleEntity,
                serialNumbers));
        assertEquals("Motorcycle already exist",
                new MotorcycleException(MotorcycleError.MOTORCYCLE_ALREADY_EXIST).getMotorcycleError().getMessage());
    }

    @Test
    void shouldThrowExceptionWhenMotorcycleWillBeFound() {
        MotorcycleValidator motorcycleValidator = new MotorcycleValidator();
        MotorcycleEntity motorcycleEntity = getMotorcycles().get(0);
        List<BikerEntity> bikers = getBikers();
//        when + then
        assertThrows(MotorcycleException.class, () -> motorcycleValidator.validationMotorcycleExist(motorcycleEntity,
                bikers));
        assertThat(MotorcycleError.MOTORCYCLE_ALREADY_EXIST.getMessage(), is("Motorcycle already exist"));
    }

    @Test
    void shouldReturnMessageWhenMotorcycleWillBeNotFound() {
        MotorcycleValidator motorcycleValidator = new MotorcycleValidator();
        MotorcycleEntity motorcycleEntity = new MotorcycleEntity();
        motorcycleEntity.setSerialNumber("ubcq782bjcs988u2rbjdicub98uij32djkqw");
        List<BikerEntity> bikers = getBikers();
//        when
        motorcycleValidator.validationMotorcycleExist(motorcycleEntity, bikers);
//        then
        System.out.println("The validateBikeExist() method did not throw an exception. The test passed");
    }

    private List<MotorcycleEntity> getMotorcycles() {
        PrepareTestData prepareTestData = new PrepareTestData();
        return prepareTestData.motorcycles();
    }

    private List<String> getSerialNumbers() {
        PrepareTestData prepareTestData = new PrepareTestData();
        return prepareTestData.serialNumbers();
    }

    private List<BikerEntity> getBikers() {
        PrepareTestData prepareTestData = new PrepareTestData();
        return prepareTestData.bikers();
    }
}