package bicycle_management.application.exception;

public class InvalidBicycleException extends RuntimeException {
    public InvalidBicycleException(IllegalArgumentException e) {}
}
