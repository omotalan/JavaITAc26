package s102_n3_e01_reservesCinema;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Cinema Reservation service. \n");
        int rows = readInt(scanner, "Number of rows: ");
        int seatsPerRow = readInt(scanner, "Seats per row: ");

        ReservationService service = new ReservationService(rows, seatsPerRow);
        ConsoleUI ui = new ConsoleUI(service, scanner);
        ui.start();
    }

    // Can't import from ConsoleUI, because scanner would have to be static in it
    private static int readInt(Scanner scanner, String prompt) {
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
}
