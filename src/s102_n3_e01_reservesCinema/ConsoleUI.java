package s102_n3_e01_reservesCinema;

import java.util.List;
import java.util.Scanner;

public class ConsoleUI {

    private ReservationService service;
    private Scanner scanner;

    public ConsoleUI(ReservationService service, Scanner scanner) {
        this.service = service;
        this.scanner = scanner;
    }

    public void start() {
        boolean running = true;
        while (running) {
            showMenu();
            int option = readInt("Option: ");

            if (option == 0) {
                System.out.println("Bye!");
                running = false;
            } else if (option == 1) {
                showAllSeats();
            } else if (option == 2) {
                showSeatsByPerson();
            } else if (option == 3) {
                reserveSeat();
            } else if (option == 4) {
                cancelSeat();
            } else if (option == 5) {
                cancelAllByPerson();
            } else {
                System.out.println("Invalid option, try again");
            }
        }
    }

    private void showMenu() {
        System.out.println();
        System.out.println("1.- Show all reserved seats");
        System.out.println("2.- Show seats reserved by someone");
        System.out.println("3.- Reserve seat");
        System.out.println("4.- Cancel seat reservation");
        System.out.println("5.- Cancel all reservations from someone");
        System.out.println("0.- Quit");
    }

    private void showAllSeats() {
        List<Seat> seats = service.getAllSeats();
        if (seats.isEmpty()) {
            System.out.println("No reservations available");
        } else {
            for (Seat seat : seats) {
                System.out.println(seat);
            }
        }
    }

    private void showSeatsByPerson() {
        String name = readLine();
        List<Seat> seats = service.getSeatsByPerson(name);
        if (seats.isEmpty()) {
            System.out.println("No reservations found for " + name + ".");
        } else {
            for (Seat seat : seats) {
                System.out.println(seat);
            }
        }
    }

    private void reserveSeat() {
        String name = readLine();
        int row = readInt("Row: ");
        int seat = readInt("Seat: ");
        try {
            service.reserveSeat(row, seat, name);
            System.out.println("Seat reserved successfully.");
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void cancelSeat() {
        int row = readInt("Row: ");
        int seat = readInt("Seat: ");
        try {
            service.cancelSeat(row, seat);
            System.out.println("Reservation cancelled successfully.");
        } catch (RuntimeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void cancelAllByPerson() {
        String name = readLine();
        List<Seat> seats = service.getSeatsByPerson(name);
        if (seats.isEmpty()) {
            System.out.println("No reservations found for " + name + ".");
        } else {
            service.cancelAllByPerson(name);
            System.out.println("Reservations cancelled successfully for " + name + ".");
        }
    }

    private int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine();
            try {
                return Integer.parseInt(line.trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Try again.");
            }
        }
    }

    private String readLine() {
        System.out.print("Person name: ");
        return scanner.nextLine();
    }
}
