package set.Ordination;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class RegisterProduct {
    private final Set<Product> products;

    public RegisterProduct() {
        this.products = new HashSet<>();
    }

    public void addProduct(long code, String name, double price, int quantity) {
        products.add(new Product(code, name, price, quantity));
    }

    public Set<Product> orderByName() {
        return new TreeSet<>(products); //TreeSet permite ordenar
    }

    public Set<Product> orderByPrice() {
        Set<Product> orderedSet = new TreeSet<>(new ComparatorByPrice());
        orderedSet.addAll(products);
        return orderedSet;

    }

    public static void main(String[] args) {
        RegisterProduct products = new RegisterProduct();

        System.out.println("Sorted by name: " + products.orderByName());

        products.addProduct(1, "Pao", 2.0, 10);
        products.addProduct(2, "Uva", 6.3, 23);
        products.addProduct(3, "Panela", 25.0, 111);
        products.addProduct(4, "Alho", 6.0, 65);

        System.out.println("Sorted by price: " +products.orderByPrice());
        System.out.println("Sorted by name: " + products.orderByName());
    }
}



class ComparatorByPrice implements Comparator<Product> {

    @Override
    public int compare(Product p1, Product p2) {
        return Double.compare(p1.getPrice(), p2.getPrice());
    }
}
