package event.management.repositories;

import event.management.entities.EventList;

import java.util.ArrayList;

public interface EventRepository {
    void addEvent(EventList event);
    void removeEvent(EventList event);
    EventList getEventByName(String nameEvent);
    ArrayList<EventList> getAllEvents();
}
