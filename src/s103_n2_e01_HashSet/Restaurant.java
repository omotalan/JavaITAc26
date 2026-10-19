package s103_n2_e01_HashSet;

import java.util.Comparator;

public class Restaurant {

    private String nom;
    private int puntuacio;


    public Restaurant(String nom, int puntuacio) {
        this.nom = nom;
        this.puntuacio = puntuacio;
    }

    public String getNom() {
        return this.nom;
    }

    public int getPuntuacio() {
        return this.puntuacio;
    }

    // Compare restaurant mechanism
    public static Comparator<Restaurant> compareRestaurant() {
        return Comparator
                .comparing(Restaurant::getNom)
                .thenComparing(Restaurant::getPuntuacio, Comparator.reverseOrder());
    }

    // Duplicate check methods
    @Override
    public boolean equals(Object other) {
        Restaurant otherRestaurant = (Restaurant) other;
        return this.puntuacio == otherRestaurant.puntuacio &&
                (this.nom == null ? otherRestaurant.nom == null : this.nom.equals(otherRestaurant.nom));
    }

    @Override
    public int hashCode() {
        // Use nom.hashCode() instead of multiplying the string directly
        int result = (nom != null ? nom.hashCode() : 0);
        return result * 31 + puntuacio;
    }

    @Override
    public String toString() {
        return "Nom: " + nom + ", Puntuació: " + puntuacio;
    }
}

