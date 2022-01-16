package pl.grzegorz.motorcycle.service.circuit;

import org.junit.jupiter.api.Test;
import pl.grzegorz.motorcycle.PrepareTestData;
import pl.grzegorz.motorcycle.exception.circuit.CircuitError;
import pl.grzegorz.motorcycle.exception.circuit.CircuitException;
import pl.grzegorz.motorcycle.model.CircuitEntity;

import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class CircuitValidatorTest {

    @Test
    void shouldReturnMessageWhenListOfCircuitsEntityWillBeNotEmpty() {
//        given
        List<CircuitEntity> circuits = getCircuits();
        CircuitValidator circuitValidator = new CircuitValidator();
//        when
        circuitValidator.validateCircuitsEmptyList(circuits);
//        then
        System.out.println("The validateEmptyList() method did not throw an exception. The test passed");
    }

    @Test
    void shouldThrowExceptionWhenListOfCircuitsEntityWillBeEmpty() {
//        given
        List<CircuitEntity> circuits = Collections.emptyList();
        CircuitValidator circuitValidator = new CircuitValidator();
//        when + then
        assertThrows(CircuitException.class, () -> circuitValidator.validateCircuitsEmptyList(circuits));
        assertThat(CircuitError.CIRCUITS_EMPTY_LIST.getMessage(),
                is("Circuits according to your parameters not found"));
    }

    private List<CircuitEntity> getCircuits() {
        PrepareTestData prepareTestData = new PrepareTestData();
        return prepareTestData.circuits();
    }

}