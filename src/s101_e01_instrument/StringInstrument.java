package s101_e01_instrument;

public class StringInstrument extends Instrument {

    StringInstrument(String name, double price) {
         super(name, price);
    }

    @Override
    public void play() {
        System.out.println("Està sonant un instrument de corda");
    }
}
