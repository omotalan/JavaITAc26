package s102_n1_e01_excepcions;

import java.util.ArrayList;

public class Sale {

    private ArrayList<Product> productList;
    private double totalPrice;

    public Sale(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public String getListItem(int index) {
        Product listItem = this.productList.get(index);
        return listItem.toString();
    }


    public double calculateTotal() {
        // Check if list is empty
        if (productList == null || productList.isEmpty()) {
            throw new EmptySaleException("Per fer una venda primer has d’afegir productes");
        }
        for (Product prod : productList) {
            totalPrice += prod.getPrice();
        }

        return totalPrice;
    }

}
