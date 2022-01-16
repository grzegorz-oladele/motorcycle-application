package pl.grzegorz.motorcycle.exception.motorcycle;

public class MotorcycleErrorInfo {

    private final String message;

    public MotorcycleErrorInfo(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
