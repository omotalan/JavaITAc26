package s101_n1_e01_instrument;

public abstract class Instrument {

    private final String name;
    private double price = 0.0;

    protected Instrument(String name, double price) {
        this.name = name;
        validatePrice(price);
        this.price = price;
    }

    // Validator
    private void validatePrice(double price) {
        if (price < 0.0) {
            throw new IllegalArgumentException("Price cannot be negative. Provided: " + price);
        }
    }

    // Getters
    public String getName() {
        return this.name;
    }
    public double getPrice() {
        return this.price;
    }

    // Setters
    public void setPrice(double price) {
        validatePrice(price);
        this.price = price;
    }

    public abstract void play();
}



