package event.management.services;

import event.management.entities.EventList;

import java.util.ArrayList;

public interface EventService {
    void addEvent(String nameEvent, String dateEvent, String eventLocation);
    void removeEvent(String nameEvent);
    void updateEvent(String nameEvent, String dateEvent, String eventLocation);
    EventList findEventByName(String nameEvent);
    ArrayList<EventList> getAllEvents();
}
