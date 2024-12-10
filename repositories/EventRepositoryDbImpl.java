package repositories;
import entities.EventList;
import config.Database;

import java.util.ArrayList;

public class EventRepositoryDbImpl implements EventRepository {
    @Override
    public void addEvent(EventList event) {
        Database.events.add(event);
    }

    @Override
    public void removeEvent(EventList event) {
        Database.events.remove(event);
    }

    @Override
    public EventList getEventByName(String nameEvent) {
        return Database.events.stream()
                .filter(event -> event.getNameEvent().equalsIgnoreCase(nameEvent))
                .findFirst()
                .orElse(null);
    }

    @Override
    public ArrayList<EventList> getAllEvents() {
        return Database.events;
    }
}
