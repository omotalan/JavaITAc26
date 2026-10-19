package s101_n2_e01_phone;

public class Phone {

    private String brand;
    private String model;

    public Phone(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public void call(String phoneNumber) {
        System.out.println("Calling number " + phoneNumber + "...");
    }

    // Getters
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }
}
