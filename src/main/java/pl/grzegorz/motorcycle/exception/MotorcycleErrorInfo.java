package pl.grzegorz.motorcycle.exception;

public class MotorcycleErrorInfo {

    private final String message;

    public MotorcycleErrorInfo(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
