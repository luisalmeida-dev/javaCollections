package set.Ordination;

import java.util.Objects;

public class Product implements Comparable<Product>{
    private final String name;
    private final long code;
    private final double price;
    private final int quantity;

    public Product(long code, String name, double price, int quantity) {
        this.name = name;
        this.code = code;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product product)) return false;
        return getCode() == product.getCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode());
    }

    public String getName() {
        return name;
    }

    public long getCode() {
        return code;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return '[' +
                "name= " + name + '\'' +
                ", code= " + code +
                ", price= " + price +
                ", quantity= " + quantity +
                ']';
    }

    @Override
    public int compareTo(Product o) {
        return name.compareToIgnoreCase(o.getName());
    }
}
