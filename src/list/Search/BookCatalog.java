package list.Search;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BookCatalog {
    List<Book> bookList;

    public BookCatalog() {
        this.bookList = new ArrayList<>();
    }

    public void addBook(String title, String author, int publicationYear) {
        Book book = new Book(title, author, publicationYear);
        bookList.add(book);
    }

    public List<Book> findByAuthor(String author) {
        return bookList.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    public List<Book> findByYearRange(int startYear, int finalYear) {
        List<Book> books = new ArrayList<>();
        for (Book book : bookList) {
            if (book.getPublicationYear() >= startYear && book.getPublicationYear() <= finalYear) {
                books.add(book);
            }
        }
        return books;
    }

    public Book findByTitle(String title) throws Exception {
        return bookList.stream()
                .filter(book -> book.getTitle().equalsIgnoreCase(title))
                .findFirst().orElse(null);

    }

    public static void main(String[] args) throws Exception {
        BookCatalog bookCatalog = new BookCatalog();

        bookCatalog.addBook("Five weeks in a ballon", "Jules Verne", 1863);
        bookCatalog.addBook("The invisible man", "H. G. Wells", 1992);
        bookCatalog.addBook("Steve Jobs", "Walter Isaacson", 2011);
        bookCatalog.addBook("The Alchemist", "Paulo Coelho", 2014);

        System.out.println(bookCatalog.findByTitle("Five weeks in a ballon"));
        System.out.println(bookCatalog.findByAuthor("Walter Isaacson"));
        System.out.println(bookCatalog.findByYearRange(1990, 2023));
    }
}
