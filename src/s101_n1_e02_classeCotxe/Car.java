package s101_n1_e02_classeCotxe;

public class Car {

    private static final String brand = "Hyundai";
    private static String model;
    private final String power;

    public Car(String power) {
        this.power = power;
    }

    public static void brake() {
        System.out.println("El vehicle està frenant");
    }

    public void accelerate() {
        System.out.println("El vehicle està accelerant");
    }
}
