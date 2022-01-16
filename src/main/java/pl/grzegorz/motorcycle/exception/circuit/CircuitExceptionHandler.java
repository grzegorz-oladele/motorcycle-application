package pl.grzegorz.motorcycle.exception.circuit;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CircuitExceptionHandler {

    @ExceptionHandler(value = CircuitException.class)
    ResponseEntity<CircuitErrorInfo> handlerCircuitException(CircuitException e) {
        HttpStatus httpStatus = HttpStatus.MULTI_STATUS;
        if (CircuitError.CIRCUIT_NOT_FOUND.equals(e.getCircuitError())) {
            httpStatus = HttpStatus.NOT_FOUND;
        }
        if (CircuitError.CIRCUIT_BAD_LENGTH.equals(e.getCircuitError())
                || CircuitError.CIRCUIT_NULL_POINTER_EXCEPTION.equals(e.getCircuitError())) {
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        return ResponseEntity.status(httpStatus).body(new CircuitErrorInfo(e.getCircuitError().getMessage()));
    }
}
