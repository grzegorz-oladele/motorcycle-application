package pl.grzegorz.motorcycle.exception.circuit;

public enum CircuitError {

    CIRCUIT_NOT_FOUND("Circuit does not exist"),
    CIRCUIT_BAD_LENGTH("Track length must be greater than 900"),
    CIRCUITS_EMPTY_LIST("Circuits according to your parameters not found"),
    CIRCUIT_NULL_POINTER_EXCEPTION("You cannot perform this operation on this object");

    private final String message;

    CircuitError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
