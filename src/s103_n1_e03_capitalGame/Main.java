package s103_n1_e03_capitalGame;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Map<String, String> countries = new HashMap<String, String>();

    public static void main(String[] args) {
        readCountries("src/s103_n3_e03_capitalGame/countries.txt");
        if (countries.size() < 10) {
            System.out.println("Not enough countries loaded");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Your name? ");
        String name = scanner.nextLine().trim();

        int score = play(scanner);

        System.out.println("Your score was " + score + "/10");
        saveScore(name, score);
    }

    private static void readCountries(String fileName) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    continue;
                }
                String[] parts = line.split("\\s+");
                if (parts.length == 2) {
                    countries.put(parts[0], parts[1]);
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Could not read file: " + fileName);
        }
    }

    private static int play(Scanner scanner) {
        List<String> keys = new ArrayList<String>(countries.keySet());
        Collections.shuffle(keys);

        int score = 0;
        for (int i = 0; i < 10; i++) {
            String country = keys.get(i);
            System.out.print("Question " + (i + 1) + ": What is the capital of " + country + "? ");
            String answer = scanner.nextLine().trim();
            if (answer.equalsIgnoreCase(countries.get(country))) {
                System.out.println("Correct!");
                score++;
            } else {
                System.out.println("Wrong. The capital of " + country + " is " + countries.get(country) + ".");
            }
        }
        return score;
    }

    private static void saveScore(String name, int score) {
        try {
            FileWriter writer = new FileWriter("src/s103_n3_e03_capitalGame/classificacio.txt", true);
            writer.write(name + " " + score);
            writer.write(System.lineSeparator());
            writer.close();
            System.out.println("Score saved to classificacio.txt");
        } catch (IOException e) {
            System.out.println("Could not save the score.");
        }
    }
}
