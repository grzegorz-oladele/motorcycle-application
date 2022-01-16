package pl.grzegorz.motorcycle.exception;

public enum MotorcycleError {

    MOTORCYCLE_NOT_FOUND("Bike does not exist"),
    MOTORCYCLE_EMPTY_LIST("Motorcycles with the specified parameters not found"),
    MOTORCYCLE_ALREADY_EXIST("Motorcycle already exist");


    private final String message;

    MotorcycleError(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
