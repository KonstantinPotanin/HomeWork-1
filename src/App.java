import Domen.HotDrink;
import Domen.Product;
import Services.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<Product> products = getProducts();

        HotDrinksVendingMachine machine = getHotDrinksVendingMachine(products);
        for (Product prod : machine.getProduct()) {
            System.out.println(prod);
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new VendingMachineGUI(products).setVisible(true);
            }
        });
    }

    private static HotDrinksVendingMachine getHotDrinksVendingMachine(List<Product> products) {
        BillAcceptor billAcceptor = new BillAcceptor();
        CoffeeContainer coffeeContainer = new CoffeeContainer();
        CoinDispenser dispenser = new CoinDispenser();
        MilkContainer milkContainer = new MilkContainer();
        PointOfSale pointOfSale = new PointOfSale();
        TeaContainer teaContainer = new TeaContainer();
        WaterContainer waterContainer = new WaterContainer();
        HotDrinksVendingMachine machine = new HotDrinksVendingMachine(billAcceptor, coffeeContainer, dispenser,
                                            milkContainer, pointOfSale, teaContainer, waterContainer, products);
        return machine;
    }

    private static List<Product> getProducts() {
        List<Product> products = new ArrayList<>();
        Product product1 = new HotDrink("Капучино", 150, 1, 80);
        Product product2 = new HotDrink("Американо", 100, 2, 90);
        Product product3 = new HotDrink("Черный чай", 50, 3, 90);
        Product product4 = new HotDrink("Черный чай с молоком", 100, 4, 80);
        Product product5 = new HotDrink("Горячий шоколад", 100, 5, 85);

        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);
        return products;
    }
}
