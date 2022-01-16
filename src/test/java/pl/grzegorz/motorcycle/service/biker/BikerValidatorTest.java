package pl.grzegorz.motorcycle.service.biker;

import org.junit.jupiter.api.Test;
import pl.grzegorz.motorcycle.PrepareTestData;
import pl.grzegorz.motorcycle.exception.biker.BikerError;
import pl.grzegorz.motorcycle.exception.biker.BikerException;
import pl.grzegorz.motorcycle.model.BikerEntity;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class BikerValidatorTest {

    @Test
    void shouldReturnMessageWhenListOfMotorcyclesWillBeNotEmpty() {
//        given
        List<BikerEntity> bikers = getBikers();
        BikerValidator bikerValidator = new BikerValidator();
//        when
        bikerValidator.validationEmptyBikerList(bikers);
//        then
        System.out.println("The validateEmptyList() method did not throw an exception. The test passed");
    }

    @Test
    void shouldThrowExceptionWhenListOfMotorcyclesWillBeEmpty() {
//        given
        List<BikerEntity> bikers = Collections.emptyList();
        BikerValidator bikerValidator = new BikerValidator();
//        when + then
        assertThrows(BikerException.class, () -> bikerValidator.validationEmptyBikerList(bikers));
        assertThat(BikerError.BIKERS_EMPTY_LIST.getMessage(), is("Bikers according to your parameters not found"));
    }

    @Test
    void shouldReturnMessageWhenEmailWillBeNotExist() {
//        given
        List<String> emails = getEmails();
        BikerValidator bikerValidator = new BikerValidator();
        BikerEntity biker = new BikerEntity();
        biker.setEmail("jorge-martin123@123.pl");
//        when
        bikerValidator.validationBikerEmail(biker, emails);
//        then
        System.out.println("The validateBikerEmail() method did not throw an exception. The test passed");
    }

    @Test
    void shouldThrowExceptionWhenEmailWillBeExist() {
//        given
        List<String> emails = getEmails();
        BikerValidator bikerValidator = new BikerValidator();
        BikerEntity biker = new BikerEntity();
        biker.setEmail("valentino-rossi123@123.pl");
//      when + then
        assertThrows(BikerException.class, () -> bikerValidator.validationBikerEmail(biker, emails));
        assertThat(BikerError.BIKER_ALREADY_EXIST.getMessage(), is("Biker does already exist"));
    }

    private List<BikerEntity> getBikers() {
        PrepareTestData prepareTestData = new PrepareTestData();
        return prepareTestData.bikers();
    }

    private List<String> getEmails() {
        PrepareTestData prepareTestData = new PrepareTestData();
        return prepareTestData.emails();
    }

}