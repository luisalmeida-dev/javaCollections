package set.BasicOperations;

public class Guest {
    private final String name;
    private final int inviteCode;

    public Guest(String name, int inviteCode) {
        this.name = name;
        this.inviteCode = inviteCode;
    }

    public String getName() {
        return name;
    }

    public int getInviteCode() {
        return inviteCode;
    }

    @Override
    public String toString() {
        return
                 '[' + "name= " + name +
                " inviteCode= " + inviteCode + ']';
    }
}
