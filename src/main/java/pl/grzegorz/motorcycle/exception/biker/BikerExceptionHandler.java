package pl.grzegorz.motorcycle.exception.biker;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class BikerExceptionHandler {

    @ExceptionHandler(value = BikerException.class)
    ResponseEntity<BikerErrorInfo> handlerBikerException(BikerException e) {
        HttpStatus httpStatus = HttpStatus.MULTI_STATUS;
        if (BikerError.BIKER_NOT_FOUND.equals(e.getBikerError())) {
            httpStatus = HttpStatus.NOT_FOUND;
        }
        if (BikerError.BIKER_ALREADY_EXIST.equals(e.getBikerError())) {
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        return ResponseEntity.status(httpStatus).body(new BikerErrorInfo(e.getBikerError().getMessage()));
    }
}
