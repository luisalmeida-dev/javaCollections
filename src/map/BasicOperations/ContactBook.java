package map.BasicOperations;

import java.util.HashMap;
import java.util.Map;

public class ContactBook {
    private final Map<String, Integer> contacts;

    public ContactBook() {
        this.contacts = new HashMap<>();
    }

    public void addContact(String name, int phone){
        contacts.put(name, phone);
    }

    public void removeContact(String name){
        contacts.remove(name);
    }

    public Map<String, Integer> getAll(){
        return contacts;
    }

    public Integer getByName(String name){
        return contacts.get(name);
    }

    public static void main(String[] args) {
        ContactBook contactBook = new ContactBook();
        System.out.println("Contacts: " + contactBook.getAll());

        contactBook.addContact("Luis", 11123);
        contactBook.addContact("Lucas", 43234);
        contactBook.addContact("Sterzada", 98930);
        contactBook.addContact("Guilherme", 80029);

        System.out.println("Contacts: " + contactBook.getAll());
        contactBook.removeContact("Lucas");
        System.out.println("Contacts: " + contactBook.getAll());

        System.out.println("Number by name: " + contactBook.getByName("Sterzada"));

    }
}
