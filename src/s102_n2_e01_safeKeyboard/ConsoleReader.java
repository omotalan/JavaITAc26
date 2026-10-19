package s102_n2_e01_safeKeyboard;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleReader {

    private static Scanner scanner = new Scanner(System.in);

    public static byte readByte(String message) {
        while (true) {
            System.out.print(message);
            try {
                byte value = scanner.nextByte();
                scanner.nextLine();
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Error de format. Torna-ho a provar.");
                scanner.nextLine();
            }
        }
    }

    public static int readInt(String message) {
        while (true) {
            System.out.print(message);
            try {
                int value = scanner.nextInt();
                scanner.nextLine();
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Error de format. Torna-ho a provar.");
                scanner.nextLine();
            }
        }
    }

    public static float readFloat(String message) {
        while (true) {
            System.out.print(message);
            try {
                float value = scanner.nextFloat();
                scanner.nextLine();
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Error de format. Torna-ho a provar.");
                scanner.nextLine();
            }
        }
    }

    public static double readDouble(String message) {
        while (true) {
            System.out.print(message);
            try {
                double value = scanner.nextDouble();
                scanner.nextLine();
                return value;
            } catch (InputMismatchException e) {
                System.out.println("Error de format. Torna-ho a provar.");
                scanner.nextLine();
            }
        }
    }

    public static char readChar(String message) {
        while (true) {
            System.out.print(message);
            String line = scanner.nextLine();
            try {
                if (line.length() != 1) {
                    throw new InvalidInputException("Nomès es pot introduir un caràcter.");
                }
                return line.charAt(0);
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage() + " Torna-ho a provar.");
            }
        }
    }

    public static String readString(String message) {
        while (true) {
            System.out.print(message);
            String line = scanner.nextLine();
            try {
                if (line.isEmpty()) {
                    throw new InvalidInputException("El texte no pot estar buit.");
                }
                return line;
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage() + " Torna-ho a provar.");
            }
        }
    }

    public static boolean readYesNo(String message) {
        while (true) {
            System.out.print(message);
            String line = scanner.nextLine();
            try {
                if (line.equals("s")) {
                    return true;
                } else if (line.equals("n")) {
                    return false;
                } else {
                    throw new InvalidInputException("Nomès es pot introduir 's' or 'n'.");
                }
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage() + " Torna-ho a provar.");
            }
        }
    }
}
