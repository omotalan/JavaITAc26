package s101_n1_e02_classeCotxe;

import s101_n1_e01_instrument.PercussionInstrument;
import s101_n1_e01_instrument.StringInstrument;
import s101_n1_e01_instrument.WindInstrument;

public class Main {
    public static void main(String[] args) {

        Car.brake();

        Car tucson = new Car("90hp");
        tucson.accelerate();
    }
}
