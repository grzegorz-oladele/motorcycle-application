package pl.grzegorz.motorcycle.exception.biker;

public enum BikerError {

    BIKER_NOT_FOUND("Biker does not exist"),
    BIKERS_EMPTY_LIST("Bikers according to your parameters not found"),
    BIKER_ALREADY_EXIST("Biker does already exist");


    private final String message;

    BikerError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
