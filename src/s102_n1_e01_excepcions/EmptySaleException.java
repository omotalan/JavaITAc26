package s102_n1_e01_excepcions;

public class EmptySaleException extends RuntimeException {
    public EmptySaleException(String message) {
        super(message);
    }
}
