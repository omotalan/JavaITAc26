package s101_n2_e01_phone;

public class Smartphone extends Phone implements Camera, Clock {

    public Smartphone(String brand, String model) {
        super(brand, model);
    }

    @Override
    public void click() {
        System.out.println("Making photo...");
    }

    @Override
    public void alarm() {
        System.out.println("Sounding alarm!");
    }

}