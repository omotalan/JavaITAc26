package s102_n1_e01_excepcions;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Product> groceries = new ArrayList<>();

        groceries.add(new Product("apples", 2.5));
        groceries.add(new Product("beer", 3.5));
        groceries.add(new Product("steak", 25));
        groceries.add(new Product("bananas", 3.85));

        Sale saleOne = new Sale(groceries);

        saleOne.getListItem(5);
    }
}
