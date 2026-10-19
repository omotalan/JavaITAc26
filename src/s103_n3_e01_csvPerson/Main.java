package s103_n3_e01_csvPerson;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<Person> persones = new ArrayList<Person>();

    public static void main(String[] args) {
        readCsv("src/s103_n3_e01_csvPerson/persones.csv");

        Scanner scanner = new Scanner(System.in);
        int option = -1;
        while (option != 0) {
            showMenu();
            option = readInt(scanner, "Opció: ");
            switch (option) {
                case 1:
                    addPerson(scanner);
                    break;
                case 2:
                    showByNom(true);
                    break;
                case 3:
                    showByNom(false);
                    break;
                case 4:
                    showByCognom(true);
                    break;
                case 5:
                    showByCognom(false);
                    break;
                case 6:
                    showByDni(true);
                    break;
                case 7:
                    showByDni(false);
                    break;
                case 0:
                    System.out.println("Adéu!");
                    break;
                default:
                    System.out.println("Opcio incorrecta.");
            }
        }
    }

    private static void showMenu() {
        System.out.println();
        System.out.println("1. Introduir persona.");
        System.out.println("2. Mostrar les persones ordenades per nom (A-Z).");
        System.out.println("3. Mostrar les persones ordenades per nom (Z-A).");
        System.out.println("4. Mostrar les persones ordenades per cognoms (A-Z).");
        System.out.println("5. Mostrar les persones ordenades per cognoms (Z-A).");
        System.out.println("6. Mostrar les persones ordenades per DNI (1-9).");
        System.out.println("7. Mostrar les persones ordenades per DNI (9-1).");
        System.out.println("0. Sortir.");
    }

    // Functionalities
    private static void addPerson(Scanner scanner) {
        String nom = readString(scanner, "Nom: ");
        String cognom = readString(scanner, "Cognom: ");
        String dni = readString(scanner, "DNI: ");
        persones.add(new Person(nom, cognom, dni));
        System.out.println("Persona afegida.");
    }

    private static void showByNom(boolean asc) {
        Comparator<Person> byNom = Comparator.comparing(Person::getNom);
        printSorted(byNom, asc);
    }

    private static void showByCognom(boolean asc) {
        Comparator<Person> byCognom = Comparator.comparing(Person::getCognom);
        printSorted(byCognom, asc);
    }

    private static void showByDni(boolean asc) {
        Comparator<Person> byDni = Comparator.comparing(Person::getDni);
        printSorted(byDni, asc);
    }


    // Helpers
    private static void printSorted(Comparator<Person> comparator, boolean asc) {
        List<Person> copy = new ArrayList<Person>(persones);
        if (asc) {
            Collections.sort(copy, comparator);
        } else {
            Collections.sort(copy, comparator.reversed());
        }

        System.out.printf("%-15s %-20s %-10s%n", "___Nom___", "____Cognoms______", "___NIF___");
        for (Person p : copy) {
            System.out.printf("%-15s %-20s %-10s%n", p.getNom(), p.getCognom(), p.getDni());
        }
    }

    private static int readInt(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            String line = scanner.nextLine();
            try {
                return Integer.parseInt(line.trim());
            } catch (NumberFormatException e) {
                System.out.println("Error de format. Torna-ho a provar.");
            }
        }
    }

    private static String readString(Scanner scanner, String message) {
        while (true) {
            System.out.print(message);
            String line = scanner.nextLine();
            if (!line.trim().isEmpty()) {
                return line;
            }
            System.out.println("El text no pot estar buit.");
        }
    }

    private static void readCsv(String fileName) {
        try {
            Scanner reader = new Scanner(new FileReader(fileName));
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                if (line.trim().isEmpty()) {
                    continue;
                }
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    persones.add(new Person(parts[0], parts[1], parts[2]));
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("No s'ha pogut llegir el fitxer: " + fileName);
        }
    }

}

