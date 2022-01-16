package pl.grzegorz.motorcycle.exception.lap;

public class LapErrorInfo {

    private final String message;

    public LapErrorInfo(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
