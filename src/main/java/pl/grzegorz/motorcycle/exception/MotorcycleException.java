package pl.grzegorz.motorcycle.exception;

public class MotorcycleException extends RuntimeException {

    private final MotorcycleError motorcycleError;

    public MotorcycleException(MotorcycleError motorcycleError) {
        this.motorcycleError = motorcycleError;
    }

    public MotorcycleError getMotorcycleError() {
        return motorcycleError;
    }
}
