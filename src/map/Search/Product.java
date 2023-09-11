package map.Search;

public class Product {
    private final String name;
    private final int quantity;
    private final double price;

    public Product(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return '[' +
                "name= " + name + '\'' +
                ", quantity= " + quantity +
                ", price= " + price +
                ']';
    }
}
