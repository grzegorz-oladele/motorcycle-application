package pl.grzegorz.motorcycle.exception.biker;

public class BikerErrorInfo {

    private final String message;

    public BikerErrorInfo(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
