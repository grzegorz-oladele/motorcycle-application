package pl.grzegorz.motorcycle.exception.circuit;

public class CircuitErrorInfo {

    private final String message;

    public CircuitErrorInfo(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
