package pl.grzegorz.motorcycle.exception.lap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class LapExceptionHandler {

    @ExceptionHandler(value = LapException.class)
    ResponseEntity<LapErrorInfo> handlerLapException(LapException e) {
        HttpStatus httpStatus = HttpStatus.MULTI_STATUS;
        if (LapError.LAP_EMPTY_LIST.equals(e.getLapError())) {
            httpStatus = HttpStatus.NOT_FOUND;
        }
        return ResponseEntity.status(httpStatus).body(new LapErrorInfo(e.getLapError().getMessage()));
    }
}
