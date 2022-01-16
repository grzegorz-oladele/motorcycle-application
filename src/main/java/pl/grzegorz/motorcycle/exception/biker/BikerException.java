package pl.grzegorz.motorcycle.exception.biker;

public class BikerException extends RuntimeException {

    private final BikerError bikerError;

    public BikerException(BikerError bikerError) {
        this.bikerError = bikerError;
    }

    public BikerError getBikerError() {
        return bikerError;
    }
}
