package set.BasicOperations;

import java.util.HashSet;
import java.util.Set;

public class Guests {
    private final Set<Guest> guestSet;

    public Guests() {
        this.guestSet = new HashSet<>();
    }

    public void addGuest(String name, int inviteCode) {
        guestSet.add(new Guest(name, inviteCode));
    }

    public void removeGuestByInviteCode(int inviteCode) {
        guestSet.removeIf(guest -> guest.getInviteCode() == inviteCode);
    }

    public int countGuests() {
        return guestSet.size();
    }

    public Set<Guest> getGuests() {
        return guestSet;
    }

    public static void main(String[] args) {
        Guests guests = new Guests();
        System.out.println("Guests Number: " + guests.countGuests());

        guests.addGuest("Luis", 123);
        guests.addGuest("Fernando", 312);
        guests.addGuest("Carlos", 543);
        guests.addGuest("Vasco", 112);

        System.out.println("Guests Number: " + guests.countGuests());
        System.out.println("Guests: " + guests.getGuests());

        guests.removeGuestByInviteCode(312);

        System.out.println("Guests Number: " + guests.countGuests());
        System.out.println("Guests: " + guests.getGuests());
    }
}
