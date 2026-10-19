package s101_n3_01_noticiesEsportives;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {
    static Scanner SC = new Scanner(System.in);
    static List<Writer> writers = new ArrayList<>();

    // UI
    public static void main(String[] args) {
        int option;
        do {
            showMenu();
            option = readNumberInput("Opció: ");
            switch (option) {
                case 1 -> addWriter();
                case 2 -> deleteWriter();
                case 3 -> addNewsArticle();
                case 4 -> deleteNewsArticle();
                case 5 -> showNewsArticles();
                case 6 -> calculatePoints();
                case 7 -> calculatePrice();
                case 0 -> System.out.println("Adéu!");
                default -> System.out.println("Opció no vàlida.");
            }
        } while (option != 0);
    }

    private static void showMenu() {
        System.out.println("""

                === REDACCIÓ ESPORTIVA ===
                1. Introduir redactor
                2. Eliminar redactor
                3. Introduir notícia a un redactor
                4. Eliminar notícia
                5. Mostrar notícies d'un redactor
                6. Calcular puntuació d'una notícia
                7. Calcular preu d'una notícia
                0. Sortir
                """);
    }

    // Options

    private static void addWriter() {
        String dni = readtext("DNI: ");
        if (searchWriter(dni).isPresent()) {
            System.out.println("Ja existeix un writer amb aquest DNI.");
            return;
        }
        String nom = readtext("Nom: ");
        writers.add(new Writer(nom, dni));
        System.out.println("Redactor afegit.");
    }

    private static void deleteWriter() {
        String dni = readtext("DNI del redactor: ");
        boolean deleted = writers.removeIf(r -> r.getDni().equalsIgnoreCase(dni));
        System.out.println(deleted ? "Redactor eliminat." : "No s'ha trobat el redactor.");
    }

    private static void addNewsArticle() {
        Optional<Writer> writer = demanarWriter();
        if (writer.isEmpty()) return;

        System.out.println("Tipus: 1-Futbol 2-Bàsquet 3-Tenis 4-F1 5-Motociclisme");
        int tipus = readNumberInput("Tipus: ");
        String titular = readtext("Titular: ");

        NewsArticle newsArticle;
        try {
            newsArticle = switch (tipus) {
                case 1 -> new FootballArticle(titular,
                        readtext("Competició: "), readtext("Club: "), readtext("Jugador: "));
                case 2 -> new BasketballArticle(titular,
                        readtext("Competició: "), readtext("Club: "));
                case 3 -> new TennisArticle(titular,
                        readtext("Competició: "), readtext("Tenistes: "));
                case 4 -> new FormulaOneArticle(titular, readtext("Escuderia: "));
                case 5 -> new MotorbikeArticle(titular, readtext("Equip: "));
                default -> null;
            };
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
            return;
        }

        if (newsArticle == null) {
            System.out.println("Tipus no vàlid.");
        } else if (writer.get().addNewsArticle(newsArticle)) {
            System.out.println("Notícia afegida: " + newsArticle);
        } else {
            System.out.println("Aquest writer ja té una notícia amb aquest titular.");
        }
    }

    private static void deleteNewsArticle() {
        Optional<Writer> writer = demanarWriter();
        if (writer.isEmpty()) return;
        String titular = readtext("Titular: ");
        boolean eliminada = writer.get().deleteNewsArticle(titular);
        System.out.println(eliminada ? "Notícia eliminada." : "No s'ha trobat la notícia.");
    }

    private static void showNewsArticles() {
        Optional<Writer> writer = demanarWriter();
        if (writer.isEmpty()) return;
        List<NewsArticle> noticies = writer.get().getNewsArticles();
        if (noticies.isEmpty()) {
            System.out.println("Aquest writer no té notícies.");
        } else {
            noticies.forEach(System.out::println);
        }
    }

    private static void calculatePoints() {
        demanarNewsArticle().ifPresent(n ->
                System.out.println("Puntuació: " + n.calculatePoints()));
    }

    private static void calculatePrice() {
        demanarNewsArticle().ifPresent(n ->
                System.out.printf("Price: %.2f €%n", n.calculatePriceNewsArticle()));
    }

    // Helpers

    private static Optional<Writer> searchWriter(String dni) {
        return writers.stream()
                .filter(r -> r.getDni().equalsIgnoreCase(dni))
                .findFirst();
    }

    private static Optional<Writer> demanarWriter() {
        String dni = readtext("DNI del redactor: ");
        Optional<Writer> r = searchWriter(dni);
        if (r.isEmpty()) System.out.println("No s'ha trobat el redactor.");
        return r;
    }

    private static Optional<NewsArticle> demanarNewsArticle() {
        Optional<Writer> writer = demanarWriter();
        if (writer.isEmpty()) return Optional.empty();
        String titular = readtext("Titular: ");
        Optional<NewsArticle> n = writer.get().searchNewsArticle(titular);
        if (n.isEmpty()) System.out.println("No s'ha trobat la notícia.");
        return n;
    }

    private static String readtext(String missatge) {
        System.out.print(missatge);
        return SC.nextLine().trim();
    }

    private static int readNumberInput(String missatge) {
        try {
            return Integer.parseInt(readtext(missatge));
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
