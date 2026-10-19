package s102_n2_e01_safeKeyboard;

public class Main {

    public static void main(String[] args) {
        // The example from the statement
        int age = ConsoleReader.readInt("Introdueix la teva edat: ");
        System.out.println("Edat: " + age);

        // A few more calls to exercise the other methods
        String name = ConsoleReader.readString("Introdueix el teu nom: ");
        char initial = ConsoleReader.readChar("Introdueix la teva inicial: ");
        double height = ConsoleReader.readDouble("Introdueix la teva alçada: ");
        boolean student = ConsoleReader.readYesNo("Ets estudiant? (s/n): ");

        System.out.println("Nom: " + name);
        System.out.println("Inicial: " + initial);
        System.out.println("Alçada: " + height);
        System.out.println("Estudiant: " + student);
    }
}