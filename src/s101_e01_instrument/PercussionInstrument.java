package s101_e01_instrument;

public class PercussionInstrument extends Instrument {

    PercussionInstrument(String name, double price) {
         super(name, price);
    }

    @Override
    public void play() {
        System.out.println("Està sonant un instrument de percussió");
    }
}
