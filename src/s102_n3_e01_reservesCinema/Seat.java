package s102_n3_e01_reservesCinema;

public class Seat {

    private int row;
    private int seat;
    private String personName;

    public Seat(int row, int seat, String personName) {
        this.row = row;
        this.seat = seat;
        this.personName = personName;
    }

    public int getRow() {
        return row;
    }

    public int getSeat() {
        return seat;
    }

    public String getPersonName() {
        return personName;
    }

    // Check equal seats: same number, same row
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        // Cast input object as Seat before comparing
        Seat otherSeat = (Seat) other;
        return otherSeat.hashCode() == this.hashCode();
    }

    public int hashCode() {
        return row * 31 + seat;
    }

    public String toString() {
        return "Row " + row + ", Seat " + seat + " -> " + personName;
    }
}

