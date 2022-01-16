package pl.grzegorz.motorcycle.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class MotorcycleExceptionHandler {

    @ExceptionHandler(value = MotorcycleException.class)
    ResponseEntity<MotorcycleErrorInfo> handlerBikeException(MotorcycleException e) {
        HttpStatus httpStatus = HttpStatus.MULTI_STATUS;
        if (MotorcycleError.MOTORCYCLE_NOT_FOUND.equals(e.getMotorcycleError())
                || MotorcycleError.MOTORCYCLE_EMPTY_LIST.equals(e.getMotorcycleError())) {
            httpStatus = HttpStatus.NOT_FOUND;
        }
        if (MotorcycleError.MOTORCYCLE_ALREADY_EXIST.equals(e.getMotorcycleError())) {
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        return ResponseEntity.status(httpStatus).body(new MotorcycleErrorInfo(e.getMotorcycleError().getMessage()));
    }
}
