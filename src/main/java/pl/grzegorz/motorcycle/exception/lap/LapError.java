package pl.grzegorz.motorcycle.exception.lap;

public enum LapError {

    LAP_EMPTY_LIST("Rides according to your parameters not found");

    private final String message;

    LapError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
