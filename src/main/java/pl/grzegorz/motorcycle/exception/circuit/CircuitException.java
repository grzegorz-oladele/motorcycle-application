package pl.grzegorz.motorcycle.exception.circuit;

public class CircuitException extends RuntimeException{

    private final CircuitError circuitError;

    public CircuitException(CircuitError circuitError) {
        this.circuitError = circuitError;
    }

    public CircuitError getCircuitError() {
        return circuitError;
    }
}
