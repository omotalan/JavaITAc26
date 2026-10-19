package s101_n1_e02_classeCotxe;

import s101_n1_e01_instrument.PercussionInstrument;
import s101_n1_e01_instrument.StringInstrument;
import s101_n1_e01_instrument.WindInstrument;

public class Main {
    public static void main(String[] args) {

        Car.brake();

        Car tucson = new Car("90hp");
        tucson.accelerate();

        // Add model to Class - it will span all instances
        Car.setModel("Elantra");
        System.out.println("Car model set successfully: " + Car.getModel());

        // Create new instance after setting model
        Car i20 = new Car("70hp");

        // Retrieve model names for each instance; all the same
        System.out.println("i20 Car instance model name: " + i20.getModel());
        System.out.println("tucson Car instance model name: " + tucson.getModel());

    }
}
