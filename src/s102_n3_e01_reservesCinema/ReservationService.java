package s102_n3_e01_reservesCinema;

import java.util.ArrayList;
import java.util.List;

public class ReservationService {

    private int totalRows;
    private int seatsPerRow;
    private List<Seat> seats;

    public ReservationService(int totalRows, int seatsPerRow) {
        this.totalRows = totalRows;
        this.seatsPerRow = seatsPerRow;
        this.seats = new ArrayList<Seat>();
    }

    public void reserveSeat(int row, int seat, String name) {
        validateSeatPosition(row, seat);
        validatePersonName(name);

        Seat newSeat = new Seat(row, seat, name);
        if (seats.contains(newSeat)) {
            throw new SeatAlreadyTakenException(
                    "Seat at row " + row + ", seat " + seat + " is already taken.");
        }
        seats.add(newSeat);
    }

    public void cancelSeat(int row, int seat) {
        validateSeatPosition(row, seat);

        Seat target = new Seat(row, seat, null);
        if (!seats.remove(target)) {
            throw new SeatAlreadyEmptyException(
                    "Seat at row " + row + ", seat " + seat + " is not reserved.");
        }
    }

    public void cancelAllByPerson(String name) {
        for (int i = seats.size() - 1; i >= 0; i--) {
            if (seats.get(i).getPersonName().equalsIgnoreCase(name)) {
                seats.remove(i);
            }
        }
    }

    public List<Seat> getAllSeats() {
        return seats;
    }

    public List<Seat> getSeatsByPerson(String name) {
        List<Seat> result = new ArrayList<Seat>();
        for (Seat seat : seats) {
            if (seat.getPersonName().equalsIgnoreCase(name)) {
                result.add(seat);
            }
        }
        return result;
    }

    private void validateSeatPosition(int row, int seat) {
        if (row < 1 || row > totalRows) {
            throw new InvalidSeatException("Row " + row + " out of range.");
        }
        if (seat < 1 || seat > seatsPerRow) {
            throw new InvalidSeatException("Seat " + seat + " out of range.");
        }
    }

    private void validatePersonName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidPersonNameException("Name cannot be empty.");
        }
        for (int i = 0; i < name.length(); i++) {
            if (Character.isDigit(name.charAt(i))) {
                throw new InvalidPersonNameException("Name cannot contain numbers.");
            }
        }
    }
}
