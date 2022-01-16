package pl.grzegorz.motorcycle.exception.lap;

public class LapException extends RuntimeException {

    private final LapError lapError;

    public LapException(LapError lapError) {
        this.lapError = lapError;
    }

    public LapError getLapError() {
        return lapError;
    }
}
