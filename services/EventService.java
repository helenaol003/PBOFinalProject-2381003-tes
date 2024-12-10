package services;

import entities.EventList;

import java.util.ArrayList;

public interface EventService {
    void addEvent(String nameEvent, String dateEvent, String eventLocation);
    void removeEvent(int index);
    ArrayList<EventList> getAllEvents();
}
