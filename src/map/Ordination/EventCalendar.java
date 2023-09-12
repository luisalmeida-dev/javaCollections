package map.Ordination;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class EventCalendar {
    private final Map<LocalDate, Event> eventMap;

    public EventCalendar() {
        this.eventMap = new HashMap<>();
    }

    public void addEvent(LocalDate date, String name, String attraction) {
        eventMap.put(date, new Event(name, attraction));
    }

    public Map<LocalDate, Event> getAllCrescent() {
        return new TreeMap<>(eventMap);
    }

    public Map<LocalDate, Event> nextEvent() {
        LocalDate now = LocalDate.now();
        Map<LocalDate, Event> orderedMap = new TreeMap<>(eventMap);
        Map.Entry<LocalDate, Event> event = null;
        for (Map.Entry<LocalDate, Event> entry : orderedMap.entrySet()) {
            if (entry.getKey().isAfter(now)) {
                event = entry;
                break;
            }
        }
        if (event != null) {
            orderedMap.clear();
            orderedMap.put(event.getKey(), event.getValue());
        }
        return orderedMap;
    }

    public static void main(String[] args) {
        EventCalendar eventCalendar = new EventCalendar();
        System.out.println("Events Crescent: " + eventCalendar.getAllCrescent());

        eventCalendar.addEvent(LocalDate.of(2023, 9, 11), "The Thow", "Travis Scott");
        eventCalendar.addEvent(LocalDate.of(2009, 3, 22), "Monza Race", "Felipe Massa");
        eventCalendar.addEvent(LocalDate.of(2023, 10, 7), "Birthday", "Luis");
        eventCalendar.addEvent(LocalDate.of(2024, 2, 1), "F1 2024", "Max Verstappen");
        eventCalendar.addEvent(LocalDate.of(2023, 9, 12), "LFA Class", "Cristiano Leher");

        System.out.println("Events Crescent: " + eventCalendar.getAllCrescent());

        System.out.println("Next event: " + eventCalendar.nextEvent());
    }
}
