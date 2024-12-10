package repositories;

import entities.EventList;

import java.util.ArrayList;

public interface EventRepository {
    void addEvent(EventList event);
    void removeEvent(EventList event);
    EventList getEventByName(String nameEvent);
    ArrayList<EventList> getAllEvents();
}
