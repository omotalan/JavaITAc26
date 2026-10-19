package s103_n3_e01_csvPerson;

public class Person {

    private String nom;
    private String cognom;
    private String dni;

    public Person(String nom, String cognom, String dni) {
        this.nom = nom;
        this.cognom = cognom;
        this.dni = dni;
    }

    public String getNom() {
        return nom;
    }

    public String getCognom() {
        return cognom;
    }

    public String getDni() {
        return dni;
    }

    @Override
    public String toString() {
        return nom + " " + cognom + " " + dni;
    }
}