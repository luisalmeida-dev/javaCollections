package map.Ordination;

public class Event {
    private final String name;
    private final String attraction;

    public Event(String name, String attraction) {
        this.name = name;
        this.attraction = attraction;
    }

    public String getName() {
        return name;
    }

    public String getAttraction() {
        return attraction;
    }

    @Override
    public String toString() {
        return '[' +
                "name= " + name +
                ", attraction= " + attraction +
                ']';
    }
}
