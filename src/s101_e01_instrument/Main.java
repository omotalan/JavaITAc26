package s101_e01_instrument;

public class Main {

    public static void main(String[] args) {

        WindInstrument flute = new WindInstrument(
                "flute",
                75.00
        );

        StringInstrument citar = new StringInstrument(
                "citar",
                275.00
        );

        PercussionInstrument agogo = new PercussionInstrument(
                "agogo",
                30.00
        );


        // Constructor feedback
        System.out.println("Wind instrument created: " + flute.getName() + "\n Instrument price: " + flute.getPrice());
        System.out.println("String instrument created: " + citar.getName() + "\n Instrument price: " + citar.getPrice());
        System.out.println("Percussion instrument created: " + agogo.getName() + "\n Instrument price: " + agogo.getPrice());

        // Call instrument play
        flute.play();
        System.out.println("\n");
        citar.play();
        System.out.println("\n");
        agogo.play();
        System.out.println("\n");
    }
}
