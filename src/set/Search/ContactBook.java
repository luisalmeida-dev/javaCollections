package set.Search;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class ContactBook {
    private final Set<Contact> contacts;

    public ContactBook() {
        this.contacts = new HashSet<>();
    }

    public void addContact(String name, int number) {
        contacts.add(new Contact(name, number));
    }

    public Set<Contact> getContacts() {
        return contacts;
    }

    public Set<Contact> getByName(String name) {
        Set<Contact> contactSet = new HashSet<>();

        return contacts.stream().filter(Contact -> Contact.getName().startsWith(name)).collect(Collectors.toSet());

//        for (Contact contact : contacts) {
//            if (contact.getName().equals(name)) {
//                contactSet.add(contact);
//            }
//        }
    }

    public void updateContact(String name, int newNumber) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                contact.setNumber(newNumber);
                break;
            }
        }
    }

    public static void main(String[] args) {
        ContactBook contactBook = new ContactBook();

        System.out.println(contactBook.getContacts());

        contactBook.addContact("Luis", 12345);
        contactBook.addContact("Fernando", 43993);
        contactBook.addContact("Sterzada", 99938);
        contactBook.addContact("Carucs", 39823);
        contactBook.addContact("Luis Eduardo", 88593);

        System.out.println("Contacs: " + contactBook.getContacts());
        System.out.println("ByName: " + contactBook.getByName("Luis"));
        contactBook.updateContact("Sterzada", 99999);
        System.out.println("Contacs: " + contactBook.getContacts());
    }
}
