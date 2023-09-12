package map.Ordination;

import java.util.*;

public class OnlineLibrary {
    private final Map<String, Book> bookMap;

    public OnlineLibrary() {
        this.bookMap = new HashMap<>();
    }

    public void addBook(String link, String title, String author, double price) {
        bookMap.put(link, new Book(title, author, price));
    }

    public void removeBook(String title) {
        for (Map.Entry<String, Book> entry : bookMap.entrySet()) {
            if (entry.getValue().getTitle().equalsIgnoreCase(title)) {
                bookMap.remove(entry.getKey());
                break;
            }
        }
    }

    public Map<String, Book> orderedByPrice() {
        List<Map.Entry<String, Book>> unorderedMap = new ArrayList<>(bookMap.entrySet());
        unorderedMap.sort(new ComparatorByPrice());
        Map<String, Book> orderedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Book> entry : unorderedMap) {
            orderedMap.put(entry.getKey(), entry.getValue());
        }
        return orderedMap;
    }

    public Map<String, Book> findAllByAuthor(String author) {
        Map<String, Book> booksByAuthor = new HashMap<>();
        for (Map.Entry<String, Book> bookEntry : bookMap.entrySet()) {
            if (bookEntry.getValue().getAuthor().equalsIgnoreCase(author)) {
                booksByAuthor.put(bookEntry.getKey(), bookEntry.getValue());
            }
        }
        return booksByAuthor;
    }

    public Book getPricierBook() {
        Book pricierBook = null;
        for (Book book : bookMap.values()) {
            if (pricierBook == null || book.getPrice() > pricierBook.getPrice()) {
                pricierBook = book;
            }
        }
        return pricierBook;
    }

    public Book getCheapestBook() {
        Book cheapestBook = null;
        for (Book book : bookMap.values()) {
            if (cheapestBook == null || book.getPrice() < cheapestBook.getPrice()) {
                cheapestBook = book;
            }
        }
        return cheapestBook;
    }

    public static void main(String[] args) {
        OnlineLibrary onlineLibrary = new OnlineLibrary();
        System.out.println("Ordered By Price: " + onlineLibrary.orderedByPrice());

        onlineLibrary.addBook("www.link0.com", "Five weeks in a balloon", "Jules Verne", 50.0);
        onlineLibrary.addBook("www.link1.com", "The invisible man", "H. G. Wells", 34.5);
        onlineLibrary.addBook("www.link2.com", "Steve Jobs", "Walter Isaacson", 125.9);
        onlineLibrary.addBook("www.link3.com", "The Alchemist", "Paulo Coelho", 65.3);
        onlineLibrary.addBook("www.link4.com", "20,000 Leagues Under the Sea", "Jules Verne", 15.5);

        System.out.println("Ordered By Price: " + onlineLibrary.orderedByPrice());

        onlineLibrary.removeBook("The Alchemist");

        System.out.println("Ordered By Price: " + onlineLibrary.orderedByPrice());
        System.out.println("Pricier Book: " + onlineLibrary.getPricierBook());
        System.out.println("Cheapest Book: " + onlineLibrary.getCheapestBook());
        System.out.println("All By Author: " + onlineLibrary.findAllByAuthor("Jules Verne"));

    }
}

class ComparatorByPrice implements Comparator<Map.Entry<String, Book>> {
    @Override
    public int compare(Map.Entry<String, Book> o1, Map.Entry<String, Book> o2) {
        return Double.compare(o1.getValue().getPrice(), o2.getValue().getPrice());
    }
}

class ComparatorByAuthor implements Comparator<Map.Entry<String, Book>> {
    @Override
    public int compare(Map.Entry<String, Book> o1, Map.Entry<String, Book> o2) {
        return o1.getValue().getAuthor().compareToIgnoreCase(o2.getValue().getAuthor());
    }
}