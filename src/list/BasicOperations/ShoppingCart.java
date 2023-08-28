package list.BasicOperations;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    List<Item> itemList;

    public ShoppingCart() {
        this.itemList = new ArrayList<>();
    }

    public void addItem(String name, double price, int quantity) {
        itemList.add(new Item(name, price, quantity));
    }

    public void removeItem(String name) {
        itemList.removeIf(item -> item.getName().equalsIgnoreCase(name));
    }

    public double calculateValue() {
        double totalValue = 0;
        for (Item item : itemList) {
            totalValue += item.getPrice() * item.getQuantity();
        }
        return totalValue;
    }

    public List<Item> returList() {
        return itemList;
    }

    public static void main(String[] args) {
        ShoppingCart shoppingCart = new ShoppingCart();

        System.out.println(shoppingCart.returList());
        System.out.println(shoppingCart.calculateValue());

        shoppingCart.addItem("Processor", 1200.00, 1);
        shoppingCart.addItem("Memory", 250.00, 2);
        shoppingCart.addItem("Mouse", 200, 1);

        System.out.println(shoppingCart.returList());
        System.out.println(shoppingCart.calculateValue());

        shoppingCart.removeItem("Mouse");
        System.out.println(shoppingCart.returList());
        System.out.println(shoppingCart.calculateValue());

    }
}
