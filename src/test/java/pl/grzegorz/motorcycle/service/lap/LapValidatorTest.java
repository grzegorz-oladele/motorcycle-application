package pl.grzegorz.motorcycle.service.lap;

import org.junit.jupiter.api.Test;
import pl.grzegorz.motorcycle.PrepareTestData;
import pl.grzegorz.motorcycle.exception.lap.LapError;
import pl.grzegorz.motorcycle.exception.lap.LapException;
import pl.grzegorz.motorcycle.model.LapEntity;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class LapValidatorTest {

    @Test
    void shouldReturnMessageWhenListOfLapsWillBeNotEmpty() {
//        given
        var listOfLaps = getLaps();
        var lapValidator = new LapValidator();
//        when
        lapValidator.validateEmptyList(listOfLaps);
//        then
        System.out.println("The validateEmptyList() method did not throw an exception. The test passed");
    }

    @Test
    void shouldThrowExceptionWhenListOfLapsWillBeEmpty() {
//        given
        List<LapEntity> listOfLaps = Collections.emptyList();
        var lapValidator = new LapValidator();
//        when + then
        assertThrows(LapException.class, () -> lapValidator.validateEmptyList(listOfLaps));
        assertThat(LapError.LAP_EMPTY_LIST.getMessage(), is("Rides according to your parameters not found"));
    }

    private List<LapEntity> getLaps() {
        PrepareTestData prepareTestData = new PrepareTestData();
        return prepareTestData.laps();
    }
}