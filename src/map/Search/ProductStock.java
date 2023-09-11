package map.Search;

import java.util.HashMap;
import java.util.Map;

public class ProductStock {
    private final Map<Long, Product> products;

    public ProductStock() {
        this.products = new HashMap<>();
    }

    public void addProduct(long code, String name, int quantity, double price) {
        products.put(code, new Product(name, quantity, price));
    }

    public Map<Long, Product> getAll() {
        return products;
    }

    public double getStockPrice() {
        double totalValue = 0;
        if (!products.isEmpty()) {
            for (Product product : products.values()) {
                totalValue += product.getQuantity() * product.getPrice();
            }
        }
        return totalValue;
    }


    public Product getPricierProduct() {
        Product pricierProduct = null;
        double highestPrice = Double.MIN_VALUE;
        if (!products.isEmpty()) {
            for (Product product : products.values()) {
                if (product.getPrice() > highestPrice) {
                    highestPrice = product.getPrice();
                    pricierProduct = product;
                }
            }
        }
        return pricierProduct;
    }

    public Product getCheapestProduct() {
        Product cheapestProdutc = null;
        double cheapestPrice = Double.MAX_VALUE;
        for (Product product : products.values()) {
            if (cheapestPrice > product.getPrice()) {
                cheapestPrice = product.getPrice();
                cheapestProdutc = product;
            }
        }
        return cheapestProdutc;
    }

    public Product getPricierProductInTotal() {
        Product pricierProductInTotal = null;
        double pricierProduct = Double.MIN_VALUE;
        for (Product product : products.values()) {
            if (product.getPrice() * product.getQuantity() > pricierProduct) {
                pricierProduct = product.getPrice() * product.getQuantity();
                pricierProductInTotal = product;
            }
        }
        return pricierProductInTotal;
    }

    public static void main(String[] args) {
        ProductStock products = new ProductStock();
        System.out.println("Products: " + products.getAll());

        products.addProduct(1L, "Television", 5, 2500.0);
        products.addProduct(2L, "SoundBar", 3, 1100.0);
        products.addProduct(3L, "Toilet Paper", 9, 12.0);
        products.addProduct(4L, "Car Tire", 33, 500.0);

        System.out.println("Products: " + products.getAll());
        System.out.println("Cheapest Product: " + products.getCheapestProduct());
        System.out.println("Pricier Product: " + products.getPricierProduct());
        System.out.println("Pricier Product In Total: " + products.getPricierProductInTotal());
        System.out.println("Total Stock Price: " + products.getStockPrice());
    }
}
