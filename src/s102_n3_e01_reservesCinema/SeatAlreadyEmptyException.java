package s102_n3_e01_reservesCinema;

public class SeatAlreadyEmptyException extends RuntimeException {
    public SeatAlreadyEmptyException(String message) {
        super(message);
    }
}
